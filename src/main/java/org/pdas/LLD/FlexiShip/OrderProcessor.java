package org.pdas.LLD.FlexiShip;

import org.pdas.LLD.FlexiShip.DiscountStrategy.DiscountStrategy;
import org.pdas.LLD.FlexiShip.ShippingProviders.ShippingStrategy;
import org.pdas.LLD.FlexiShip.ShippingProviders.ShippingStrategyFactory;

import java.math.BigDecimal;

// class should be able to process Order
public class OrderProcessor {


    private final DiscountStrategy discountStrategy;
    private final ShippingStrategyFactory shippingStrategyFactory;


    public OrderProcessor(DiscountStrategy discountStrategy, ShippingStrategyFactory shippingStrategyFactory){
        this.discountStrategy = discountStrategy;
        this.shippingStrategyFactory = shippingStrategyFactory;
    }

    public BigDecimal processOrder(Order order){


        // 1. Calculate the base shipping cost via the strategy factory
        ShippingStrategy strategy = shippingStrategyFactory.getStrategy(order.getShippingProvider());
        BigDecimal baseShippingPrice = strategy.calculateShipping(order);
        BigDecimal discountedPrice = discountStrategy.applyDiscount(order);
        BigDecimal finalPrice = baseShippingPrice.subtract(discountedPrice);
        return finalPrice;



    }
}
