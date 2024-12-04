package org.pdas.arrays.javaQ;

public class TestParrale {
    public static void main(String[] args) {
        Runnable task = new MyRunnable();
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(MyRunnable.counter);
    }
}
