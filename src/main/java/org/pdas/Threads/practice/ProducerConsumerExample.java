package org.pdas.Threads.practice;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
    private static int capacity;
    private static final Queue<Integer> queue = new LinkedList<>();

    ProducerConsumerExample(int capacity){
        this.capacity = capacity;

    }

    public synchronized void producer(int value) throws InterruptedException {
        while (queue.size() == capacity){
            wait();
        }
        queue.add(value);
        System.out.println("Produced: "+value);
        notifyAll();

    }

    public synchronized int consumer() throws InterruptedException {
        if (queue.isEmpty()){
            wait();
        }

        int value = queue.poll();
        System.out.println("Consumed: "+value);
        notifyAll();
        return value;
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerExample example = new ProducerConsumerExample(5);

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    example.producer(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    example.consumer();
                    Thread.sleep(150);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producerThread.start();
        consumerThread.start();
        producerThread.join();
        consumerThread.join();
    }
}
