package org.pdas.designPatterns.Structural.decorator;

public class SugarDecorator extends BeverageDecorator{
    public SugarDecorator(Beverage coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedBeverage.getDescription()+" ,Sugar";
    }

    @Override
    public double getCost() {
        return decoratedBeverage.getCost()+0.10;
    }
}
