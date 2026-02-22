package org.pdas.LLD.InterceptorsWithGateLevelValidation.TokenValidator;

import org.pdas.LLD.InterceptorsWithGateLevelValidation.User.User;

import java.util.Map;

public class TokenValidationResult {
    private final boolean valid;
    private final String message;
    private final int errorCode;
    private final User user;
    private final Map<String, Object> claims;

    private TokenValidationResult(Builder builder){
        this.valid = builder.valid;
        this.message = builder.message;
        this.errorCode = builder.errorCode;
        this.user = builder.user;
        this.claims = builder.claims;

    }

    public static TokenValidationResult success(User user, Map<String, Object> claims) {
        return new Builder()
                .user(user)
                .claims(claims)
                .valid(true)
                .message("ToneValidationResults: passed")
                .build();
    }

    public static TokenValidationResult failure(String message) {
        return new Builder()
                .valid(false)
                .message(message)
                .build();
    }

    public Map<String, Object> getClaims() {
        return claims;
    }

    public User getUser() {
        return user;
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public static class Builder{
        private boolean valid;
        private String message;
        private int errorCode;
        private User user;
        private Map<String, Object> claims;

        public Builder valid(boolean valid){
            this.valid = valid;
            return this;
        }

        public Builder message(String message){
            this.message = message;
            return this;
        }

        public Builder claims(Map<String, Object> claims){
            this.claims = claims;
            return this;
        }

        public Builder user(User user){
            this.user = user;
            return this;
        }

        public Builder errorCode(int errorCode){
            this.errorCode = errorCode;
            return this;
        }

        public TokenValidationResult build(){
            return new TokenValidationResult(this);
        }
    }
}
