package org.pdas.LLD.InterceptorsWithGateLevelValidation;

public interface Gate {
    String getName();
    GateType getType();
    boolean supports(RequestContext context);
    ValidationResult validate(RequestContext context);
    int getOrder();
}
