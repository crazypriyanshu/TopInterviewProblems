package org.pdas.designPatterns.Structural.decorator;

public class SimpleCoffee implements Beverage {
    @Override
    public String getDescription() {
        return "This is a simple coffee";

    }

    @Override
    public double getCost() {
        return 0.50;
    }
}
