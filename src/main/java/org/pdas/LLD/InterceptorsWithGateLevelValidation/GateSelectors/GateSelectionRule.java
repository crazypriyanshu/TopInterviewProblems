package org.pdas.LLD.InterceptorsWithGateLevelValidation.GateSelectors;

import org.pdas.LLD.InterceptorsWithGateLevelValidation.RequestContext;

import java.util.List;

@FunctionalInterface
public interface GateSelectionRule {
    List<String> getGatesForContext(RequestContext context);
}
