package org.pdas.a;

public class Speed5 extends AbstractClassDemo{
    public final String name = "Player5";
    public Speed5(){
        System.out.println("***Speed 5****");
    }

    public String getName() {
        return name;
    }

    @Override
    void increment() {
        count = count+5;
//        System.out.println("***Player5 score "+count);
    }

    @Override
    void decrement() {
        count = count-2;
//        System.out.println("Player5 score "+count+" **");
    }


}
