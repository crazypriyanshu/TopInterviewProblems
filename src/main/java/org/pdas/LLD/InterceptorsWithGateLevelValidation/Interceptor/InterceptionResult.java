package org.pdas.LLD.InterceptorsWithGateLevelValidation.Interceptor;

import org.pdas.LLD.InterceptorsWithGateLevelValidation.ValidationResult;
import org.pdas.arrays.javaQ.B;

import java.util.Collections;
import java.util.Map;

public class InterceptionResult {
    private final boolean valid;
    private final String requestId;
    private final int errorCode;
    private final String message;
    private final Map<String, Object> details;
    private final Map<String, ValidationResult> validationResults;
    private final long duration;

    private InterceptionResult(Builder builder){
        this.valid = builder.valid;
        this.requestId = builder.requestId;
        this.errorCode = builder.errorCode;
        this.message = builder.message;
        this.duration = builder.duration;
        this.details = builder.details != null ? Collections.unmodifiableMap(builder.details) : Collections.emptyMap();
        this.validationResults = builder.validationResults != null ? Collections.unmodifiableMap(builder.validationResults) : Collections.emptyMap();
    }

    public boolean isValid() {
        return valid;
    }

    public String getRequestId() {
        return requestId;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public Map<String, ValidationResult> getValidationResults() {
        return validationResults;
    }

    public long getDuration() {
        return duration;
    }

    public static class Builder{
        private boolean valid;
        private String requestId;
        private int errorCode;
        private String message;
        private Map<String, Object> details;
        private Map<String, ValidationResult> validationResults;
        private long duration;

        public Builder valid(boolean valid){
            this.valid = valid;
            return this;
        }

        public Builder requestId(String requestId){
            this.requestId = requestId;
            return this;
        }

        public Builder errorCode(int errorCode){
            this.errorCode = errorCode;
            return this;
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public Builder duration(long duration){
            this.duration = duration;
            return this;
        }

        public Builder validationResults(Map<String, ValidationResult> validationResults){
            this.validationResults = validationResults;
            return this;
        }

        public Builder details(Map<String, Object> details){
            this.details = details;
            return this;
        }

        public InterceptionResult build(){
            return new InterceptionResult(this);
        }
    }

}
