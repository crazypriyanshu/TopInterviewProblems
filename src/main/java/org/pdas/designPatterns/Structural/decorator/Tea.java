package org.pdas.designPatterns.Structural.decorator;

public class Tea implements Beverage{
    @Override
    public String getDescription() {
        return "This is a Tea";
    }

    @Override
    public double getCost() {
        return 0.5;
    }
}
