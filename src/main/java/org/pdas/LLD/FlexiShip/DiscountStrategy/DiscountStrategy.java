package org.pdas.LLD.FlexiShip.DiscountStrategy;

import org.pdas.LLD.FlexiShip.Order;

import java.math.BigDecimal;

public interface DiscountStrategy {
    BigDecimal applyDiscount(Order order);
}
