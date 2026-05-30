package org.pdas.a;

/**
 * Simple rate limiter based on token bucket algorithm
 * */
public class TokenBucketRateLimiter {
    private  int capacity; // 100 tokens capacity
    private  int refillRate; // 100 tokens per minute
    private int tokens;
    private long lastRefillTime;


    public TokenBucketRateLimiter(int capacity, int refillRate){
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTime = System.nanoTime();
    }

    public boolean allowRequest(){
        refill();
        if (this.tokens >= 1){
            tokens -= 1;
            return true;
        }
        return false;
    }

    private void refill(){
        long now = System.nanoTime();
        double timeElapsedInMin = (now - lastRefillTime)/60_000_000_000.00;
        double tokensToAdd = timeElapsedInMin * refillRate;
        tokens = (int) Math.min(capacity, tokens+tokensToAdd);
        lastRefillTime = now;
    }

}
