package org.pdas.inteview;

import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        PSafeCache<String, String> cache = new PSafeCache<>();
        cache.put(String.valueOf(System.currentTimeMillis()), "value", 2);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                cache.put(String.valueOf(System.currentTimeMillis()), "value", 2);
            }
        };

        for (int i = 0; i < 6; i++) {
            System.out.println("creating thread");
            Thread thread = new Thread(task);
            thread.setName("Worker"+i);
            thread.start();
        }

        System.out.println(cache.size());
        cache.print();

        System.out.println("Adding entries with various TTLs...");
        cache.put("user1", "John Doe", 5);   // Expires in 5 seconds
        cache.put("session_token", "abc-123", 10); // Expires in 10 seconds
        cache.put("data_key", "some_important_data", 60); // Expires in 60 seconds

        System.out.println("Current cache size: " + cache.size());
        cache.print();

        cache.cleanup();
        cache.size();
//        System.out.println("Retrieving 'user1' immediately: " + cache.get("user1"));
//        System.out.println("Retrieving 'data_key' immediately: " + cache.get("data_key"));
//
//        // Wait for 'user1' to expire
//        System.out.println("Waiting 6 seconds for 'user1' to expire...");
//        TimeUnit.SECONDS.sleep(6);
//        System.out.println("Retrieving 'user1' after 6 seconds: " + cache.get("user1"));
//        System.out.println("Current cache size after 'user1' expiration: " + cache.size());
//
//        // Wait for 'session_token' to expire
//        System.out.println("Waiting another 5 seconds for 'session_token' to expire...");
//        TimeUnit.SECONDS.sleep(5);
//        System.out.println("Retrieving 'session_token': " + cache.get("session_token"));
//        System.out.println("Current cache size: " + cache.size());


    }
}
