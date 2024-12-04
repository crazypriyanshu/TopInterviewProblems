package org.pdas.arrays.javaQ;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RetLockExample {
    private int counter = 0;
    private Lock lock = new ReentrantLock();
    public void incrementCounter(){
        lock.lock();
        try {
            counter++;
        }finally {
            lock.unlock();
        }
    }

    public int getCounter(){
        return counter;
    }

    public static void main(String[] args) {
        RetLockExample example = new RetLockExample();
        for (int i=0; i< 5; i++){
            new Thread(() -> {
                for (int j=0; j < 1000; j++){
                    example.incrementCounter();
                }
            }).start();
        }
        int cou = example.getCounter();
        System.out.println(cou);
    }
}
