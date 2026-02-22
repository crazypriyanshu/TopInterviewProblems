package org.pdas.LLD.InterceptorsWithGateLevelValidation.RateLimiter;

import lombok.Data;
import lombok.Getter;

@Data
public class RateLimiterResult {
    private final boolean allowed;
    private final int remainingTokens;
    private final long retryAfterMillis;

    public RateLimiterResult(boolean allowed, int remainingTokens, long retryAfterMillis) {
        this.allowed = allowed;
        this.remainingTokens = remainingTokens;
        this.retryAfterMillis = retryAfterMillis;
    }

}
