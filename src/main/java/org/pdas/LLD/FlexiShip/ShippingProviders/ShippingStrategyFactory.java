package org.pdas.LLD.FlexiShip.ShippingProviders;

import java.util.Map;

public class ShippingStrategyFactory {
    private final Map<String, ShippingStrategy> strategyMap;
    public ShippingStrategyFactory(){
        strategyMap = Map.of("DHL", new DHLShippingStrategy(),
                "FEDEX", new FedExShippingStrategy());
    }

    public ShippingStrategy getStrategy(String carrier){
        ShippingStrategy strategy = strategyMap.get(carrier.toUpperCase());
        if (strategy == null){
            throw new IllegalArgumentException("Invalid carrier");
        }
        return strategy;
    }
}
