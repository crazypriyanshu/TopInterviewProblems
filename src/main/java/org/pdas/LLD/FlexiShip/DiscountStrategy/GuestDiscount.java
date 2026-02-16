package org.pdas.LLD.FlexiShip.DiscountStrategy;

import org.pdas.LLD.FlexiShip.Order;
import org.pdas.LLD.FlexiShip.OrderProcessor;

import java.math.BigDecimal;

public class GuestDiscount implements DiscountStrategy{
    @Override
    public BigDecimal applyDiscount(Order order) {
        return BigDecimal.ONE;
    }
}
