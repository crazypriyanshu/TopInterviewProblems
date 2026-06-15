package org.pdas.designPatterns.PLAYGROUND.structural;

public abstract class AddOnDecorator implements Beverage{
    protected final Beverage beverage;

    AddOnDecorator(Beverage beverage){
        this.beverage = beverage;
    }
}
