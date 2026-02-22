package org.pdas.LLD.InterceptorsWithGateLevelValidation.GateSelectors;

import org.pdas.LLD.InterceptorsWithGateLevelValidation.Gate;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.RequestContext;

import java.util.*;
import java.util.stream.Collectors;

public class DefaultGateSelector implements GateSelector{
    private final Map<String, GateSelectionRule> rules;
    private final GateSelector fallbackGateSelector;

    DefaultGateSelector(){
        this.rules = new HashMap<>();
        this.fallbackGateSelector = new PathBasedGateSelector();
        initializeDefaultRules();
    }

    public void initializeDefaultRules(){
        rules.put("public-api", context -> context.getPath().startsWith("/public") ? Arrays.asList("reteLimiting") : null);
        rules.put("admin-api", context ->
                context.getPath().startsWith("/admin/") ?
                        Arrays.asList("authentication", "authorization", "audit") : null
        );
    }
    @Override
    public List<Gate> selectGates(RequestContext context, List<Gate> availableGates) {
        Set<String> selectedGateNames = new LinkedHashSet<>();

        // apply rules:
        for (GateSelectionRule rule: rules.values()){
            List<String> ruleGates = rule.getGatesForContext(context);
            if (ruleGates != null){
                selectedGateNames.addAll(ruleGates);
            }
        }

        // if no rules are matching - fallback
        if (selectedGateNames.isEmpty()){
            return fallbackGateSelector.selectGates(context, availableGates);
        }

        // filter and sort available gates
        return availableGates.stream()
                .filter(gate -> selectedGateNames.contains(gate.getName()))
                .sorted(Comparator.comparingInt(Gate::getOrder))
                .collect(Collectors.toList());

    }

    public void addRule(String ruleName, GateSelectionRule rule){
        rules.put(ruleName, rule);
    }
}
