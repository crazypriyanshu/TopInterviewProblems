package org.pdas.Threads.multiThreading.producerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {
    private  static int capacity;
    private static final Queue<Integer> queue = new LinkedList<>();
    ProducerConsumerExample(int capacity){
        this.capacity = capacity;
    }

    public synchronized void produce(int val) throws InterruptedException {
        while (queue.size() == capacity){
            System.out.println("Waiting for the queue to be empty to produce value");
            wait();
        }
        queue.add(val);
        notifyAll();
        System.out.println("Added in queue: "+ val);
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()){
            wait();
        }
        int val = queue.poll();
        notifyAll();
        System.out.println("consumed from queue "+val);
        return val;
    }

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumerExample example = new ProducerConsumerExample(5);

        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    example.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    example.consume();
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
