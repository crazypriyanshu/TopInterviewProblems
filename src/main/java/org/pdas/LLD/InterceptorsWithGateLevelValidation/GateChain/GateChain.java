package org.pdas.LLD.InterceptorsWithGateLevelValidation.GateChain;

import org.pdas.LLD.InterceptorsWithGateLevelValidation.Gate;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.RequestContext;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.ValidationResult;

import java.util.*;

public class GateChain {
    private final List<Gate> gates;
    private final RequestContext requestContext;
    private final Map<String, ValidationResult> results;
    private int currentIndex;

    public GateChain(List<Gate> gates, RequestContext context){
        this.gates = new ArrayList<>(gates);
        this.requestContext = context;
        this.results = new LinkedHashMap<>();
        this.currentIndex = 0;
    }

    public ValidationResult proceed(){
        if (currentIndex > gates.size()){
            return ValidationResult.success("gateChain");
        }

        Gate currentGate = gates.get(currentIndex++);

        try {
            // check if this gate supports this context
            if (!currentGate.supports(requestContext)){
                return proceed(); // skip gate and continue
            }

            ValidationResult result = currentGate.validate(requestContext);
            results.put(currentGate.getName(), result);

            if (!result.isValid()){
                return result;
            }

            return proceed();
        } catch (Exception e) {
            ValidationResult errorResult = ValidationResult.failure(
                    currentGate.getName(),
                    "Gate Execution error "+e.getMessage(),
                    500
            );
            results.put(currentGate.getName(), errorResult);
            return errorResult;
        }

    }

    public Map<String, ValidationResult> getResults(){
        return Collections.unmodifiableMap(results);
    }
}
