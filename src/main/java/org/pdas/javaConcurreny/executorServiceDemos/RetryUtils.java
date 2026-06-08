package org.pdas.javaConcurreny.executorServiceDemos;

import java.time.Duration;
import java.util.Set;
import java.util.function.Supplier;

public class RetryUtils {
    public static final String api1 = "https://httpbin.org/delay/5";
    public static final String api2 = "https://httpbin.org/status/503";

    public static class RetryConfig{
        private final int maxDuration;
        private final Duration baseDelay;
        private final Duration maxDelay;
        private final int MAX_ATTEMPTS;
        private final Set<Class<? extends Throwable>> retryable;


        private RetryConfig(Builder builder){
            this.maxDelay = builder.maxDelay;
            this.baseDelay = builder.baseDelay;
            this.maxDuration = builder.maxDuration;
            this.MAX_ATTEMPTS = builder.maxAttempts;
            this.retryable = builder.retryable;
        }

        public int getMaxDuration() {
            return maxDuration;
        }

        public Duration getBaseDelay() {
            return baseDelay;
        }

        public Duration getMaxDelay() {
            return maxDelay;
        }

        public int getMAX_ATTEMPTS() {
            return MAX_ATTEMPTS;
        }

        public Set<Class<? extends Throwable>> getRetryable() {
            return retryable;
        }

        static class Builder{
            private int maxDuration = 2;
            private Duration baseDelay = Duration.ofMillis(100);
            private Duration maxDelay = Duration.ofSeconds(2);
            private int maxAttempts = 3;
            private Set<Class<? extends Throwable>> retryable;

            public Builder setMaxDuration(int maxDuration){
                this.maxDuration = maxDuration;
                return this;
            }

            public Builder setMaxAttempts(int maxAttempts){
                this.maxAttempts = maxAttempts;
                return this;
            }

            public Builder setBaseDelay(Duration baseDelay){
                this.baseDelay = baseDelay;
                return this;
            }

            public Builder setMaxDelay(Duration maxDelay){
                this.maxDelay = maxDelay;
                return this;
            }

            public Builder setRetryable(Set<Class<? extends Throwable>> retryable){
                this.retryable = retryable;
                return this;
            }

            public RetryConfig build(){
                if (baseDelay.isNegative() || maxDelay.isNegative()){
                    throw new IllegalArgumentException("baseDelay or maxDelay can't be negative");
                }
                if (maxAttempts < 1){
                    throw new IllegalStateException("maxAttempts has to be greater than 1");
                }
                return new RetryConfig(this);
            }
        }


    }

    public static <T> T executeWithRetry(Supplier<T> operation, RetryConfig retryConfig){
        int attempt = 0;
        while (true) {
            try {
                System.out.println("Attempt: "+attempt);
                attempt++;
                return operation.get();
            } catch (Throwable throwable){
                if (attempt >= retryConfig.MAX_ATTEMPTS || !isRetryable(throwable,retryConfig.retryable )){
                    // after max attempts we throw exception
                    throw throwable;
                }

                long backOffMillis = calculateJitteredBackOff(attempt, retryConfig);
                System.out.printf("[Retry Engine]: Attempt %d failed due to %s, retrying in %d ms", attempt, throwable.getClass().getName(), backOffMillis);
                try {
                    Thread.sleep(backOffMillis);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException("Retry execution interrupted");
                }
            }
        }

    }

    //
    private static long calculateJitteredBackOff(int attempt, RetryConfig config){
        // calculate exponential backoff
        long rawBackOff = config.baseDelay.toMillis() * (1L << (attempt-1));
        long cappedBackOff = Math.min(config.maxDelay.toMillis(), rawBackOff);
        return cappedBackOff;
    }

    private static boolean isRetryable(Throwable throwable, Set<Class<? extends Throwable>> retryableExceptions){
        return retryableExceptions.stream()
                .anyMatch(exception -> exception.isAssignableFrom(throwable.getClass()));
    }

}
