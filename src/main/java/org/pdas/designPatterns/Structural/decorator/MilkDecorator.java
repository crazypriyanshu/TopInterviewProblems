package org.pdas.designPatterns.Structural.decorator;

public class MilkDecorator extends BeverageDecorator{
    public MilkDecorator(Beverage coffee) {
        super(coffee);
    }

    public String getDescription(){
        return decoratedBeverage.getDescription() + ", Milk";
    }

    public double getCost(){
        return decoratedBeverage.getCost()+ 0.50;
    }
}
