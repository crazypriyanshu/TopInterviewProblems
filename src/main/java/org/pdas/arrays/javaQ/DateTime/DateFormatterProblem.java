package org.pdas.arrays.javaQ.DateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DateFormatterProblem {
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    static final AtomicInteger count = new AtomicInteger(1);
    static ExecutorService regulatoryPool = Executors.newFixedThreadPool(20, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {

            return new Thread(r, "RegWorker-"+count);
        }
    });


    public static void main(String[] args) {
//        Runnable task = () -> {
//            String result = FORMAT.format(new Date());
//            System.out.println(result.toString()+ " from: "+Thread.currentThread().getName());
//
//        };
//        Thread[] threads = new Thread[5];
//        for (int i = 0; i < 5; i++) {
//            threads[i] = new Thread(task, "Thread1-"+i);
//
//        }
//        for (Thread thread: threads){
//            System.out.println("Loop running threads- "+Thread.currentThread().getName());
//            thread.start();
//        }


        List<String> playerIds = new ArrayList<>();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        playerIds.addAll(List.of("Ram", "Shayam", "Amar", "Daisy"));

        for (String playerId: playerIds){
            futures.add(processTransaction(playerId));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Total approved transaction "+ count.get());
        regulatoryPool.shutdown();




    }

    public static CompletableFuture<Void> processTransaction(String playerId){
        CompletableFuture<Boolean> kyc = CompletableFuture.supplyAsync(() -> performKyc(playerId), regulatoryPool);
        CompletableFuture<Boolean> geo = CompletableFuture.supplyAsync(() -> performGeoLocation(playerId), regulatoryPool);

        return kyc
                .thenCombine(geo, (isKycOk, isGeoOk) -> isGeoOk && isKycOk)
                .thenAccept(approved -> {
                    if(approved) {
                        count.incrementAndGet();
                        System.out.println(count.get());
                        System.out.println("Sending to kafka template to player: "+playerId+ " on thread: "+Thread.currentThread().getName());
                    }
                });

    }

    public static Boolean performKyc(String playerId){
        System.out.println("performing KYC: "+playerId);
        return true;
    }

    public static Boolean performGeoLocation(String playerId){
        System.out.println("performing geoLocation: "+playerId);
        return true;
    }
}
