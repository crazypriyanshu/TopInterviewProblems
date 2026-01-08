package org.pdas.designPatterns.Structural.decorator;

public abstract class BeverageDecorator implements Beverage {
    protected Beverage decoratedBeverage;

    public BeverageDecorator(Beverage coffee){
        this.decoratedBeverage = coffee;
    }


    @Override
    public String getDescription() {
        return (decoratedBeverage.getDescription());
    }

    @Override
    public double getCost() {
        return decoratedBeverage.getCost();
    }
}
