package org.pdas.LLD.InterceptorsWithGateLevelValidation.RateLimiter;

public interface RateLimiter {
    RateLimiterResult checkLimit(String key);
}
