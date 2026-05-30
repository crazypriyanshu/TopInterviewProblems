package org.pdas.popularInterview.pipeLine;



import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;

public class HighThroughputPipeline {

    private static final Logger log = Logger.getLogger(HighThroughputPipeline.class.getName());

    private static final int QUEUE_CAPACITY = 5000;
    private static final int CONSUMER_THREADS = Runtime.getRuntime().availableProcessors();

    private final BlockingQueue<WorkTask> taskQueue = new LinkedBlockingQueue<>(QUEUE_CAPACITY);
    private final ExecutorService consumerPool = Executors.newFixedThreadPool(CONSUMER_THREADS);

    private final AtomicBoolean isRunning = new AtomicBoolean(false);

    /**
     * Initialization of consumer threads and add tasks into consumer pool
     * */
    public void startConsumer(){
        log.info("Initializing consumer threads optimized for CPU: "+ CONSUMER_THREADS);
        for (int i = 0; i < CONSUMER_THREADS; i++) {
            consumerPool.submit(this::consumeLoop);
        }
    }

    /**
     * Producer method to add tasks
     * It handles the backpressure gracefully by blocking when queue is full
     * */
    public void submitTasks(WorkTask task){
        if (isRunning.get()){
            throw new IllegalStateException("Pipeline is shutting down, submissions rejected");
        }
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.info("Producer thread interrupted as it is waiting for the queue to clear backpressure");
        }
    }

    /**
     * Consumer loop running inside ExecutorService consumer pool
     * */
    private void consumeLoop(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                WorkTask task = taskQueue.take();
                process(task);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.info("Consumer thread interrupted via signal");
            }
        }
    }

    /**
     * Logic to process high level task
     * */
    private void process(WorkTask workTask){
        try {
            log.info("Processing high level task: "+workTask.taskId());
        } catch (Exception e) {
            log.info("Exception while processing the task");
        }
    }

    public void shutDownGracefully(){
        if (isRunning.compareAndSet(false, true)){
            return;
        }
        log.info("Initiating graceful shutdown sequence...");

        consumerPool.shutdown();

        try {
            // await for standing
            if (consumerPool.awaitTermination(30, TimeUnit.SECONDS)){
                log.info("Queue draining timed out. Forcing hard shutdown phase.");
                consumerPool.shutdown();
                if(!consumerPool.awaitTermination(10, TimeUnit.SECONDS)){
                    log.info("Executor service failed to terminate completely.");
                }
            }
        } catch (InterruptedException e) {
            consumerPool.shutdown();
            Thread.currentThread().interrupt();

        }
        log.info("Pipeline closed. Remaining unprocessed tasks: "+taskQueue.size());
    }

}
