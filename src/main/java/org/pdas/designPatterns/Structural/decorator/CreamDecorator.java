package org.pdas.designPatterns.Structural.decorator;

public class CreamDecorator extends BeverageDecorator{
    public CreamDecorator(Beverage coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedBeverage.getDescription()+" , Whipped cream";
    }

    @Override
    public double getCost() {
        return decoratedBeverage.getCost()+1.00;
    }
}
