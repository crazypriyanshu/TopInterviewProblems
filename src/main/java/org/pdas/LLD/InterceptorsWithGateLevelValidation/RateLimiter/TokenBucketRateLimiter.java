package org.pdas.LLD.InterceptorsWithGateLevelValidation.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
// Token Bucket Algorithm
public class TokenBucketRateLimiter implements RateLimiter{
    private static class Bucket {
        double tokens;
        long lastRefillTimestamp;

        Bucket(int capacity) {
            this.tokens = capacity;
            this.lastRefillTimestamp = System.currentTimeMillis();
        }
    }

    private final int maxCapacity;
    private final int refillRatePerSecond;
    private final ConcurrentHashMap<String, Bucket> buckets = new ConcurrentHashMap<>();

    public TokenBucketRateLimiter(int maxCapacity, int refillRatePerSecond){
        this.maxCapacity = maxCapacity;
        this.refillRatePerSecond = refillRatePerSecond;
    }

    private void refillBucket(Bucket bucket){
        long now = System.currentTimeMillis();
        long deltaInMillis = now - bucket.lastRefillTimestamp;
        // We need to calculate tokens to add based on time passed
        double tokensToAdd = (deltaInMillis * refillRatePerSecond)/1000.0;
        bucket.tokens = Math.min(maxCapacity, bucket.tokens + tokensToAdd);
        bucket.lastRefillTimestamp = now;
    }

    public RateLimiterResult checkLimit(String key){
        // ComputeIfAbsent is atomic in ConcurrentHashMap
        Bucket bucket = buckets.computeIfAbsent(key,k -> new Bucket(maxCapacity));

        synchronized (bucket){
            refillBucket(bucket);
            if (bucket.tokens >= 1){
                bucket.tokens -= 1;
                return new RateLimiterResult(true, (int) bucket.tokens, 0);
            } else {
                long waitTime = (long) (((1.0 - bucket.tokens) / refillRatePerSecond) * 1000);
                return new RateLimiterResult(false, 0, waitTime);
            }

        }
    }
}
