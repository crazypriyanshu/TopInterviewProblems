package org.pdas.a;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.Lock;

public class Test1 {
    private static final int MAX = 10;
    private static int counter = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {
//        Thread t1 = new Thread(new SequenceRunnable(1),"T1");
//        Thread t2 = new Thread(new SequenceRunnable(2),"T2");
//        Thread t3 = new Thread(new SequenceRunnable(0),"T3");
//        t1.start();
//        t2.start();
//        t3.start();


    }

    static class SequenceRunnable implements Runnable{
        private final int threadId;
        public SequenceRunnable(int threadId){
            this.threadId = threadId;
        }

        @Override
        public void run() {
            while (counter <= MAX){
                synchronized (lock){
                    while (counter <= MAX && counter%3 != threadId){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    if (counter <= MAX){
                        System.out.println(Thread.currentThread().getName()+ " : "+counter);
                        counter++;
                    }
                    lock.notifyAll();
                }
            }

        }
    }

    static class HeartBeat implements Runnable{
        private int interval;
        HeartBeat(int secs){
            this.interval = secs;
        }

        @Override
        public void run() {
            System.out.println("Coming from "+Thread.currentThread().getName());
        }
    }
}
