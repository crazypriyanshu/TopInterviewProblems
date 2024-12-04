package org.pdas.arrays.javaQ;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExamples {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Callable<Integer> task = () -> {
            Thread.sleep(2000);
            return 42;
        };
        Future<Integer> future = executorService.submit(task);
        boolean isDone = future.isDone();
        System.out.println(isDone);
        Thread.sleep(3000);
        System.out.println(future.isDone());
        executorService.shutdown();
    }
}
