package org.pdas.LLD.InterceptorsWithGateLevelValidation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ValidationResult {
    private final boolean valid;
    private final String gateName;
    private final String message;
    private final int errorCode;
    private final Map<String, Object> details;

    private ValidationResult(Builder builder){
        this.valid = builder.valid;
        this.gateName = builder.gateName;
        this.message = builder.message;
        this.errorCode = builder.errorCode;
        this.details = builder.details != null ? Collections.unmodifiableMap(builder.details): Collections.emptyMap();

    }

    public static ValidationResult success(String gateName){
        return new Builder()
                .valid(true)
                .gateName(gateName)
                .message("Validation Passed")
                .build();
    }

    public static ValidationResult failure(String gateName, String message, int errorCode){
        return new Builder()
                .valid(false)
                .gateName(gateName)
                .message(message)
                .errorCode(errorCode)
                .build();
    }

    public boolean isValid() {
        return valid;
    }

    public String getGateName() {
        return gateName;
    }

    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public static class Builder{

        private boolean valid;
        private String gateName;
        private String message;
        private int errorCode;
        private Map<String, Object> details;

        public Builder valid(boolean valid){
            this.valid = valid;
            return this;
        }

        public Builder gateName(String gateName){
            this.gateName = gateName;
            return this;
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public Builder errorCode(int errorCode){
            this.errorCode = errorCode;
            return this;
        }

        public Builder details(Map<String, Object> details){
            if (this.details == null){
                this.details = new HashMap<>();
            }
            this.details.putAll(details);
            return this;
        }

        public Builder detail(String key, String value){
            if (this.details == null){
                this.details = new HashMap<>();
            }
            this.details.put(key, value);
            return this;
        }

        public ValidationResult build(){
            return new ValidationResult(this);
        }


    }
}
