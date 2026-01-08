package org.pdas.designPatterns.Structural.decorator;

public class BeverageShop {
    public static void main(String[] args) {
        // Customer want coffee with milk and sugar

        Beverage customer1Coffee = new SimpleCoffee();
        customer1Coffee = new MilkDecorator(customer1Coffee);
        customer1Coffee = new SugarDecorator(customer1Coffee);

        System.out.println(customer1Coffee.getDescription());
        System.out.println(customer1Coffee.getCost());

        Beverage customer2Coffee = new SimpleCoffee();
        customer2Coffee = new MilkDecorator(customer2Coffee);
        customer2Coffee = new SugarSyrupDecorator(customer2Coffee);
        customer2Coffee = new SugarDecorator(customer2Coffee);
        customer2Coffee = new SugarDecorator(customer2Coffee);
        customer2Coffee = new CreamDecorator(customer1Coffee);
        System.out.println(customer2Coffee.getDescription());
        System.out.println(customer2Coffee.getCost());


    }
}
