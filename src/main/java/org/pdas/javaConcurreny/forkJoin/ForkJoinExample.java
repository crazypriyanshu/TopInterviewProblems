package org.pdas.javaConcurreny.forkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {
    static class SumTask extends RecursiveTask<Long> {
        private final long[] numbers;
        private final int start;
        private final int end;

        private static final int THRESHOLD = 10_000;

        SumTask(long[] numbers, int start, int end) {
            this.numbers = numbers;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            int length = end - start;
            if (length < THRESHOLD){
                long sum = 0;
                for (int i = 0; i< end; i++){
                    sum += numbers[i];
                }
                return sum;
            } else {
                // recursive case if task is too big, split it
                int mid = start + (length/2);
                SumTask leftTask = new SumTask(numbers, start, mid);
                SumTask rightTask = new SumTask(numbers, mid+1, end);

                leftTask.fork();

                Long rightResult = rightTask.compute();

                Long leftResult = leftTask.join();

                return leftResult + rightResult;
            }

        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long[] numbers = new long[100_0000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        SumTask task = new SumTask(numbers, 0, numbers.length);

        long result = forkJoinPool.invoke(task);
        System.out.println("Final Result :"+ result+" time taken: "+(System.currentTimeMillis() - startTime)+ " ms");
    }
}
