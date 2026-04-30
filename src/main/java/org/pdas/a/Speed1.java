package org.pdas.a;

public class Speed1 extends AbstractClassDemo{
    public Speed1(){
        System.out.println("*Speed 1*");
    }

    public String getName() {
        return name;
    }

    public final String name = "Player1";
    @Override
    void increment() {
        count = count+1;
        //System.out.println("Player1 *score: "+count);
    }

    @Override
    void decrement() {
        count = count;
        //System.out.println("Player1 score: "+count);
    }


}
