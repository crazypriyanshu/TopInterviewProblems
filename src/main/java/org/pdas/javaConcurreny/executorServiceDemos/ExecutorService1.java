package org.pdas.javaConcurreny.executorServiceDemos;

import java.util.concurrent.*;

public class ExecutorService1 {
    private static final int FIXED_SIZE = 5;
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(FIXED_SIZE);

        Runnable task1 = () -> {
            System.out.println(Thread.currentThread().getName()+" : is calling Task 1");
        };

        Runnable task2 = () -> {
            System.out.println(Thread.currentThread().getName()+" : is calling Task 2");
        };

        Callable callableTask1 = () -> {
            System.out.println("Callable task is called by: "+Thread.currentThread().getName());
            return "Callable task called";
        };

        executorService.execute(task1);
        Future ans = executorService.submit(task2);
        try {
            Future ans2 = executorService.submit(callableTask1);
            System.out.println(ans2.get());
        } catch (InterruptedException e) {
            System.out.println("[ERROR]: Exception: ");
            throw new RuntimeException(e);
        }

        System.out.println(ans.get());

        executorService.shutdown();


    }

}
