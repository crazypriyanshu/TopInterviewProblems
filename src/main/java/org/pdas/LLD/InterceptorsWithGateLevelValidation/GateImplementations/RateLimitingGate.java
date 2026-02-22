package org.pdas.LLD.InterceptorsWithGateLevelValidation.GateImplementations;

import org.pdas.LLD.InterceptorsWithGateLevelValidation.AbstractGate;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.GateType;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.RateLimiter.RateLimiterResult;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.RateLimiter.TokenBucketRateLimiter;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.RequestContext;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.ValidationResult;

public class RateLimitingGate extends AbstractGate {
    private final TokenBucketRateLimiter rateLimiter;

    public RateLimitingGate(String name, GateType gateType, int order, TokenBucketRateLimiter rateLimiter) {
        super(name, gateType, order);
        this.rateLimiter = rateLimiter;
        addSupportedPath("/api/**");
    }

    @Override
    protected boolean doSupport(RequestContext context) {
        return true;
    }

    private String getClientIdIdentifier(RequestContext requestContext){
        String forwardedFor = requestContext.getHeaders().get("X-Forwarded-For");
        if (forwardedFor != null){
            return forwardedFor.split(",")[0].trim();
        }
        return requestContext.getHeaders().getOrDefault("X-Real-Ip", "unknown");
    }

    public ValidationResult validate(RequestContext context){
        String clientId =getClientIdIdentifier(context);
        String key = context.getPath()+":" + clientId;
        RateLimiterResult result = rateLimiter.checkLimit(key);

        if (result.isAllowed()){
            context.getAttributes().put("rateLimitRemaining", result.getRemainingTokens());
            context.getAttributes().put("rateLimitReset", result.getRetryAfterMillis());
            return ValidationResult.success(getName());
        } else {
            return new ValidationResult.Builder()
                    .valid(false)
                    .gateName(getName())
                    .message("Rate Limit Exceeded")
                    .errorCode(429)
                    .detail("limit",String.valueOf(result.getRetryAfterMillis()))
                    .build();
        }

    }
}
