package org.pdas.arrays.javaQ;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
//    public static AtomicInteger counter=new AtomicInteger(0);
    public static Integer counter = 0;
    public static void main(String[] args) throws InterruptedException {
        int x = 10;
        Runnable r = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+ " is attempting to update, initial counter value "+counter);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            int newValue = counter++;
            System.out.println(threadName+ " incremented counter , new val "+ counter);
        };
        for (int i=0; i < 300; i++){
            Thread thread_i = new Thread(r);
            thread_i.setName("thead_"+i);
            System.out.println(Thread.currentThread().getName()+" is running & current val count "+counter);
            thread_i.start();

        }

        Thread.sleep(5000);


    }
}
