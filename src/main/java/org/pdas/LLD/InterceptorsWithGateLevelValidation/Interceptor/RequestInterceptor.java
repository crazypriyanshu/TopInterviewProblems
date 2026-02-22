package org.pdas.LLD.InterceptorsWithGateLevelValidation.Interceptor;

import org.pdas.LLD.InterceptorsWithGateLevelValidation.Gate;
import org.pdas.LLD.InterceptorsWithGateLevelValidation.GateSelectors.GateSelector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RequestInterceptor {
    private final List<Gate> gates;
    private final GateSelector gateSelector;
    private final InterceptorConfig interceptorConfig;
    private final MetricsCollector metricsCollector;

    public RequestInterceptor(InterceptorConfig interceptorConfig, GateSelector gateSelector, MetricsCollector metricsCollector){
        this.interceptorConfig = interceptorConfig;
        this.gateSelector = gateSelector;
        this.metricsCollector = metricsCollector;
        this.gates = new ArrayList<>();
    }

    public void registerGate(Gate gate){
        gates.add(gate);
        gates.sort(Comparator.comparingInt(Gate::getOrder));
    }

    public void registerGates(List<Gate> gates){
        this.gates.addAll(gates);
        this.gates.sort(Comparator.comparingInt(Gate::getOrder));
    }





}
