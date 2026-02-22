package org.pdas.LLD.InterceptorsWithGateLevelValidation.GateImplementations;

import org.pdas.LLD.InterceptorsWithGateLevelValidation.AbstractGate;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.GateType;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.RequestContext;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.TokenValidator.TokenValidationResult;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.TokenValidator.TokenValidator;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.ValidationResult;

public class AuthenticationGate extends AbstractGate {
    private final TokenValidator tokenValidator;


    protected AuthenticationGate(TokenValidator tokenValidator) {
        super("authentication", GateType.AUTHENTICATION, 100);
        this.tokenValidator = tokenValidator;
        addSupportedMethod("GET");
        addSupportedMethod("POST");
        addSupportedMethod("PUT");
        addSupportedMethod("DELETE");
    }


    @Override
    protected boolean doSupport(RequestContext context) {
        return !context.getPath().startsWith("/public");
    }

    @Override
    public ValidationResult validate(RequestContext context) {
        String authHeader = context.getHeaders().get("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ValidationResult.failure(
                    getName(),
                    "Missing or invalid Authorization header",
                    401
            );
        }

        String token = authHeader.substring(7);
        try {
            TokenValidationResult result = tokenValidator.validate(token);
            if (result.isValid()){
                context.getAttributes().put("authenticatedUser", result.getUser());
                return ValidationResult.success(getName());
            } else {
                return ValidationResult.failure(
                        getName(),
                        result.getMessage(),
                        401
                );
            }

        } catch (Exception e) {
            return ValidationResult.failure(
                    getName(),
                    "Authentication failed: " + e.getMessage(),
                    401
            );
        }
    }
}
