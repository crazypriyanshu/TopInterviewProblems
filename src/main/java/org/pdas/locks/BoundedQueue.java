package org.pdas.locks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A utility class which represents a Queue which is designed for a multi-threaded application
 * A bounded Q has a capacity which is greater than 0
 * Producers - should be able to put something in the queue
 * Consumers -  should be able to get something from the queue
 * We would use Lock to block the access
 * */
public class BoundedQueue<T> {
    private final int capacity;

    private Lock lock = new ReentrantLock(true); // fairness in the lock
    Queue<T> q = new LinkedList<T>();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();
    private volatile boolean isShutDown = false;


    public BoundedQueue(int capacity){
        if (capacity <= 0){
            throw new RuntimeException("Capacity needs to be greater than 0");
        }
        this.capacity = capacity; // this becomes the queue capacity
    }

    /**
     * Will be used by the Producer methods
     * */
    public void put(T item) throws InterruptedException {
        lock.lockInterruptibly();
        // if we just block the thread with lock.lock(), then - if a thread is blocked waiting to get into standard synchronized - it ignores interrupt flag and stays stuck in memory
        // by using lockInterruptibly() method we are making sure that lock receives an interrupt signal, it wakes up instantly, and throws Interrupted Exception and exit gracefully
        try {
            if (isShutDown){
                throw new IllegalStateException("Shutdown triggered, can't accept");
            }
            while (q.size() == capacity){
                System.out.println("[Producer]: Q is full for thread -  "+Thread.currentThread().getName());
                notFull.await();
                if (isShutDown){
                    throw new IllegalStateException("Q is shutting down while waiting to put");
                }
            }
            System.out.println("Q is adding item-"+item.toString()+" with thread: "+Thread.currentThread().getName());
            q.add(item);
            // signal waiting consumer that queue is empty and you can fetch data
            notEmpty.signal();

        } finally {
            lock.unlock();
        }
    }

    /**
     * Consumer will consume via take method
     * */
    public T get() throws InterruptedException {
        long now = System.nanoTime();
        lock.lockInterruptibly();
        try {
            if (isShutDown){
                return null;
            }
            while (q.isEmpty()){
                System.out.println("[Consumer]: Q is empty, consumers sleeping... "+Thread.currentThread().getName()+ " at time: "+System.currentTimeMillis());
                notEmpty.await(); // releases lock and suspends the consumer threads
            }
            T data = q.poll();
            System.out.println("[Consumer]: removed an item: "+ Thread.currentThread().getName()+ " data: "+ data);
            // signal any waiting producer that space has opened up
            notFull.signal();
            return data;

        } finally {
            lock.unlock();
            System.out.println("Time taken to take item: "+(System.nanoTime()-now));
        }
    }

    public int size(){
        lock.lock();
        try {
            return q.size();
        } finally {
            lock.unlock();
        }
    }

    public void triggerShutdown(){
        lock.lock();
        try {
            isShutDown = true;
            System.out.println("[System]: Broadcast triggered");
            notFull.signalAll();
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
