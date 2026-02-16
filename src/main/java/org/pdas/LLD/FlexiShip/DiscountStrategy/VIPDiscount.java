package org.pdas.LLD.FlexiShip.DiscountStrategy;

import org.pdas.LLD.FlexiShip.Order;

import java.math.BigDecimal;

public class VIPDiscount implements DiscountStrategy {

    @Override
    public BigDecimal applyDiscount(Order order) {
        // BigDecimal discountedPrice = order.getPrice().multiply(BigDecimal.valueOf(0.3));
        return BigDecimal.ZERO;
    }
}
