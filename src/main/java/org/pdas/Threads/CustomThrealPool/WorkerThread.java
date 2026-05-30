package org.pdas.Threads.CustomThrealPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Each Worker thread has its own queue
 * */
public class WorkerThread extends Thread{
    private final BlockingQueue<Runnable> taskQueue;
    private final AtomicBoolean isStopped;

    WorkerThread(BlockingQueue<Runnable> queue, AtomicBoolean isStopped){
        this.taskQueue = queue;
        this.isStopped = isStopped;
    }

    @Override
    public void run(){
        while (!isStopped.get()){
            try {
                // removes the head of the queue and keep waiting until a task is there
                Runnable task = taskQueue.take();
                task.run();
            } catch (InterruptedException e) {
                if (isStopped.get()) return;
            } catch (Exception e) {
                System.err.println("Task Failed exception: "+e.getMessage());
            }
        }

    }
}
