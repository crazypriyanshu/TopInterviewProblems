package org.pdas.designPatterns.PLAYGROUND.structural;

public class Client {
    public static void main(String[] args) {
        Beverage beverage = new Expresso();
        System.out.println(beverage.getDescription()+"  --- "+beverage.getPrice());
        beverage = new Milk(beverage);
        System.out.println(beverage.getDescription() + " ---- "+beverage.getPrice());
        beverage = new Whip(beverage);
        System.out.println(beverage.getDescription() + " ---- "+beverage.getPrice());


    }
}
