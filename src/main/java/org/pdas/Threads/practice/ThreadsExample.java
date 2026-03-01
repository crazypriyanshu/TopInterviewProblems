package org.pdas.Threads.practice;

public class ThreadsExample {
    private static void doSomething(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        int MAX = 1000;

        Thread thread = new Thread(ThreadsExample::doSomething);
        for (int i = 0; i < MAX; i++) {
            Thread thread1 = new Thread(ThreadsExample::doSomething);
            thread1.start();
        }
    }
}
