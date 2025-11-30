package org.pdas.Threads;

import java.time.Duration;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class MultiThreding {
    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor() ){
            IntStream.range(0, 10).forEach(i -> {
                executor.submit(() -> {
                    Thread.sleep(Duration.ofSeconds(1));
                    System.out.println("i="+i);
                    return i;
                });
            });
        }

    }
}
