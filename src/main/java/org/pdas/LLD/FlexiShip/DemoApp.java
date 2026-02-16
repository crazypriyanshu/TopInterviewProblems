package org.pdas.LLD.FlexiShip;

import org.pdas.LLD.FlexiShip.DiscountStrategy.VIPDiscount;
import org.pdas.LLD.FlexiShip.ShippingProviders.ShippingStrategyFactory;

import java.math.BigDecimal;

public class DemoApp {
    public static void main(String[] args) {

        Order order1 = Order.builder()
                .Id(1L)
                .shippingProvider("DHL")
                .customerType(CustomerTypes.VIP)
                .distance(25)
                .weight(11)
                .build();

        OrderProcessor orderProcessor  = new OrderProcessor(new VIPDiscount(), new ShippingStrategyFactory());
        System.out.println(orderProcessor.processOrder(order1));
    }
}
