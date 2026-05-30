package org.pdas.a;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ToenDemo {
    public static void main(String[] args) throws IOException {
//        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(100, 5);
//        for (int i = 0; i < 300; i++) {
//            System.out.println(" request "+i+" allowed: "+rateLimiter.allowRequest());
//        }
//        String apiKey = "ABC123";
//        Map<String, TokenBucketRateLimiter> map = new ConcurrentHashMap<>();
//        TokenBucketRateLimiter limiter = map.computeIfAbsent(apiKey, k -> new TokenBucketRateLimiter(10, 10));
//        if (!limiter.allowRequest()){
//            throw new RuntimeException("Too many request");

        ConcurrentTokenBucketAlgorithm bucketAlgorithm = new ConcurrentTokenBucketAlgorithm(10, 10);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Request");
            }
        };
        demonstrate();

    }
    public static void demonstrate() throws IOException {
        File file = File.createTempFile("abc", "ced");
        try {
            int result = 10 / 0; // Throws ArithmeticException
        }
//        catch (ArithmeticException e){
//            System.out.println("Cannot divide by 0");
//        }
        finally {
            String s = "A";
            s.length(); // Throws NullPointerException
        }
    }


}
