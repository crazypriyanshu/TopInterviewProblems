package org.pdas.a;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Thread safe token bucket algorithm
 * We have a fixed capacity of tokens and after every request is allowed we delete 1 token
 * and refill bucket with refill rate per minute at every tick
 * */
public class ConcurrentTokenBucketAlgorithm {
    private final long capacity;
    private final double refillRatePerNano;

    static class State{
        final double tokens;
        final long lastRefillTime;
        State( double tokens, long lastRefillTime){
            this.tokens = tokens;
            this.lastRefillTime = lastRefillTime;
        }
    }

    private final AtomicReference<State> state;

    public ConcurrentTokenBucketAlgorithm(int capacity, int refillRatePerMinute){
        this.capacity = capacity;
        // pre calculate the rate per nano sec
        this.refillRatePerNano = refillRatePerMinute/ 60_000_000_000.0;
        this.state = new AtomicReference<>(new State(capacity, System.nanoTime()));
    }

    public boolean allowRequest(){
        while (true){
            long now = System.nanoTime();
            State curr = state.get();

            double timeElapsed = Math.max(0, now-curr.lastRefillTime);
            double tokenToAdd = timeElapsed * refillRatePerNano;
            double newToken = Math.min(capacity, curr.tokens+tokenToAdd);

            if (newToken < 1.0){
                System.out.println("no token left");
                return false;
            }
            State next = new State(newToken-1, now);
            if (state.compareAndSet(curr, next)){
                System.out.println("Utilized 1 token");
                return true;
            }
        }
    }

}
