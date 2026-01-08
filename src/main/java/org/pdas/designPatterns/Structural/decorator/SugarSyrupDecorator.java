package org.pdas.designPatterns.Structural.decorator;

public class SugarSyrupDecorator extends BeverageDecorator{
    public SugarSyrupDecorator(Beverage coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedBeverage.getDescription()+" ,SugarSyrup";
    }

    @Override
    public double getCost() {
        return decoratedBeverage.getCost()+0.20;
    }
}
