package org.pdas.LLD.FlexiShip.ShippingProviders;

import org.pdas.LLD.FlexiShip.Order;

import java.math.BigDecimal;

public class FedExShippingStrategy implements ShippingStrategy{
    @Override
    public BigDecimal calculateShipping(Order order) {
        return BigDecimal.valueOf(order.getDistance()*2); // 2 per KM rate
    }
}
