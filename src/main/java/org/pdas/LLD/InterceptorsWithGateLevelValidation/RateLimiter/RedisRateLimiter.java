package org.pdas.LLD.InterceptorsWithGateLevelValidation.RateLimiter;

import java.util.concurrent.atomic.AtomicLong;

public class RedisRateLimiter implements RateLimiter{
    @Override
    public RateLimiterResult checkLimit(String key) {
        return null;
    }

//    public static class RateLimiterInfo{
//        private AtomicLong count;
//        private final long resetTime;
//        RateLimiterInfo()
//    }
}
