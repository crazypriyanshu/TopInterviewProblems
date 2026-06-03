package org.pdas.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        BoundedQueue<String> q = new BoundedQueue<>(10);

        // :lightbulb
        // 1. Create a Thread Pool instead of loose raw threads.
        // We allocate 6 worker threads total (matching your 1 producer + 5 background producers scenario)
        ExecutorService producerPool = Executors.newFixedThreadPool(6);
        ExecutorService consumerPool = Executors.newFixedThreadPool(6);

        Runnable producerTask = () -> {
            int taskNumber = 1;
            try {
                while (taskNumber <= 5) {
                    q.put("Task-" + taskNumber);
                    taskNumber++;
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                // Thread pools rely on checking the interrupted status flag to halt execution cleanly
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName() + " was interrupted while executing.");
            }
        };

        Runnable consumerTask = () -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Thread.sleep(200);
                    String data = q.get();
                    if (data == null) {
                        break; // Queue shut down, exit loop cleanly
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // 💡 2. Submit the workloads to the pools.
        // The pool manages the thread allocation under the hood.
        for (int i = 0; i < 6; i++) {
            producerPool.submit(producerTask);
            consumerPool.submit(consumerTask);
        }

        // Let the simulation run for a bit
        Thread.sleep(2000);

        // 💡 3. Gracefully dismantle the execution environment
        System.out.println("Starting shutdown sequence...");
        q.triggerShutdown(); // Unblock anyone sleeping inside conditions

        // Tell the pools to stop accepting new tasks and begin winding down active workers
        producerPool.shutdown();
        consumerPool.shutdown();

        try {
            // Block main thread temporarily to allow active workers to finish current cycles safely
            if (!producerPool.awaitTermination(3, TimeUnit.SECONDS)) {
                producerPool.shutdownNow(); // Force kill workers if they ignore graceful requests
            }
            if (!consumerPool.awaitTermination(3, TimeUnit.SECONDS)) {
                consumerPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            producerPool.shutdownNow();
            consumerPool.shutdownNow();
        }

        System.out.println("All thread pools completely dismantled. App clean.");
    }
}