package org.pdas.designPatterns.PLAYGROUND.structural;

public class Milk extends AddOnDecorator{

    public Milk(Beverage beverage){
        super(beverage);
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+" Milk";
    }

    @Override
    public double getPrice() {
        return beverage.getPrice()+5.0;
    }
}
