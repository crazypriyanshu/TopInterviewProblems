package org.pdas.LLD.InterceptorsWithGateLevelValidation.GateSelectors;

import org.pdas.LLD.InterceptorsWithGateLevelValidation.Gate;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.RequestContext;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PathBasedGateSelector implements GateSelector{
    @Override
    public List<Gate> selectGates(RequestContext context, List<Gate> availableGates) {
        return availableGates.stream()
                .filter(gate -> gate.supports(context))
                .sorted(Comparator.comparingInt(Gate::getOrder))
                .collect(Collectors.toList());
    }
}
