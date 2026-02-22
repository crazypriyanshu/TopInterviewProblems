package org.pdas.LLD.InterceptorsWithGateLevelValidation.TokenValidator;

import org.pdas.LLD.InterceptorsWithGateLevelValidation.User.User;

import java.util.*;

public class JwtTokenValidator implements TokenValidator{

    private final String secret;
    private final Set<String> validIssuers;

    public JwtTokenValidator(){
        this.secret = "secret-key";
        this.validIssuers = new HashSet<>(Arrays.asList("auth-service"));
    }

    public String getSecret() {
        return secret;
    }

    public Set<String> getValidIssuers() {
        return validIssuers;
    }

    @Override
    public TokenValidationResult validate(String token) {
        try {
            Map<String, Object> claims = new HashMap<>();
            claims.put("sub", "user1234");
            claims.put("roles", Arrays.asList("USER", "ADMIN"));
            User user = new User(12001L, "jhon", "jhon@example.com", claims);
            return TokenValidationResult.success(user, claims);
        } catch (Exception e) {
            return TokenValidationResult.failure(e.getMessage());
        }
    }
}
