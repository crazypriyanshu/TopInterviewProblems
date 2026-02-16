package org.pdas.LLD.FlexiShip.ShippingProviders;

import org.pdas.LLD.FlexiShip.Order;

import java.math.BigDecimal;

public interface ShippingStrategy {
    BigDecimal calculateShipping(Order order);
}
