package org.pdas.dp;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Test {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
//        try(executor) {
//            for (int i = 0; i < 100; i++) {
//                int id = i;
//                executor.submit(() -> {
//                    System.out.println("Running task id "+id+ " in "+Thread.currentThread().toString());
//                });
//            }
//
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }

        ThreadFactory factory = Thread.ofVirtual().name("vthread-", 0).factory();
        ExecutorService customExecutor = Executors.newThreadPerTaskExecutor(factory);

        try (customExecutor) {
            for (int i = 0; i < 100; i++) {
                customExecutor.submit(() -> {
                    System.out.println("Custom named thread: " + Thread.currentThread().getName());
                });

            }

        }
    }
}
