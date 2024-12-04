package org.pdas.arrays.javaQ;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQExample {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Waiting to take an element...");
                Integer item = queue.take();  // Will block if the queue is empty
                System.out.println("Consumed: " + item);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        consumer.start();
        Thread.sleep(2000);  // Wait to demonstrate blocking behavior

        System.out.println("Adding an element to the queue...");
        queue.put(10);  // Once an element is added, the consumer thread will unblock and take it
    }
}
