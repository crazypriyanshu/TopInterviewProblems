package org.pdas.designPatterns.PLAYGROUND.structural;

public class Whip extends AddOnDecorator{


    Whip(Beverage beverage){
        super(beverage);
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+" Whip Cream";
    }

    @Override
    public double getPrice() {
        return beverage.getPrice()+5.00;
    }
}
