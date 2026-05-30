package org.pdas.Threads.CustomThrealPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Custom thread pool - contains
 *
 * BlockingQueue -
 * */
public class CustomThreadPool {
    private final BlockingQueue<Runnable> taskQ;
    private final List<WorkerThread> workers;
    private final int poolSize;
    private final AtomicBoolean isStopped = new AtomicBoolean(false);

    CustomThreadPool(int poolSize, int maxTasks){
        this.poolSize = poolSize;
        this.workers = new ArrayList<>();
        taskQ = new ArrayBlockingQueue<>(maxTasks);
        for (int i = 0; i < poolSize; i++) {
            WorkerThread workerThread = new WorkerThread(taskQ, isStopped);
            workers.add(workerThread);
            workerThread.start();
        }
    }

    public void execute(Runnable task) throws InterruptedException {
        if (isStopped.get()){
            throw new IllegalStateException("Thread pool is stopped ");
        }
        this.taskQ.put(task);
    }

    public synchronized void stop(){
        this.isStopped.set(true);
        for (WorkerThread worker: workers){
            worker.interrupt();
        }
    }

}
