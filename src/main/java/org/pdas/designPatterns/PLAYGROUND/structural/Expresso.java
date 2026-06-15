package org.pdas.designPatterns.PLAYGROUND.structural;

public class Expresso implements Beverage{
    @Override
    public String getDescription() {
        return "Expresso";
    }

    @Override
    public double getPrice() {
        return 10.00;
    }
}
