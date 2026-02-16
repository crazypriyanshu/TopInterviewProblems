package org.pdas.LLD.FlexiShip.DiscountStrategy;

import org.pdas.LLD.FlexiShip.Order;

import java.math.BigDecimal;

public class BigBillionFlatDiscount implements DiscountStrategy{

    @Override
    public BigDecimal applyDiscount(Order order) {
        // deep logic set to apply
        return BigDecimal.valueOf(0.3);
    }
}
