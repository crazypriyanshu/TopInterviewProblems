package org.pdas.Threads.practice;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblemWithBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);


        Runnable producer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put(i);
                    System.out.println("Produced in blocking: "+i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable consumer = () -> {
            try {
                while (true){
                    int val = queue.take();
                    Thread.sleep(150);
                    System.out.println("Consumed blocking Queue: "+val);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        };

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
