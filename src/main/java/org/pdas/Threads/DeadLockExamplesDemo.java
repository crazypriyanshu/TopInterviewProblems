package org.pdas.Threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExamplesDemo {
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void method1(){
        lock1.lock();
        try {
            System.out.println(Thread.currentThread().getName()+ "has acquired lock 1");
            Thread.sleep(200);

            lock2.lock();
            try {
                System.out.println(Thread.currentThread().getName()+ " has acquired lock 2");
                Thread.sleep(300);
            }
            finally {
                lock2.unlock();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock1.unlock();
        }
    }

//    public void method2(){
//        lock2.lock();
//        try {
//            System.out.println("Thread "+ Thread.currentThread().getName()+ " has acquired lock2");
//            try {
//                System.out.println(" Thread "+ Thread.currentThread().getName()+ " has acquired lock 1");
//
//            }
//            finally {
//                lock1.unlock();
//            }
//
//        } catch (InterruptedException e) {
//            throw new RuntimeException("Deadlock!!");
//        }
//        finally {
//            lock2.unlock();
//        }
//
//    }
public void method2() {
    lock2.lock();
    try {
        System.out.println("Thread " + Thread.currentThread().getName() + " acquired lock2 in method2.");
        // Simulate some work
        Thread.sleep(100);

        lock1.lock();  // Try to acquire lock1 after lock2
        try {
            System.out.println("Thread " + Thread.currentThread().getName() + " acquired lock1 in method2.");
        } finally {
            lock1.unlock();
        }
    } catch (InterruptedException e) {
        e.printStackTrace();
    } finally {
        lock2.unlock();
    }
}

    public static void main(String[] args) {
        DeadLockExamplesDemo deadLockExamplesDemo = new DeadLockExamplesDemo();
        Thread t1 = new Thread(deadLockExamplesDemo::method1);
        Thread t2 = new Thread(deadLockExamplesDemo::method2);
        t2.start();
        t1.start();

        // this code will create deadlock

    }
}
