package org.pdas.LLD.InterceptorsWithGateLevelValidation.GateSelectors;

import org.pdas.LLD.InterceptorsWithGateLevelValidation.Gate;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.RequestContext;

import java.util.List;

@FunctionalInterface
public interface GateSelector {
    List<Gate> selectGates(RequestContext context, List<Gate> availableGates);
}
