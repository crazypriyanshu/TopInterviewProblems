package org.pdas.a;

public class Speed6 extends AbstractClassDemo{
    public final String name = "Player6";
    public Speed6(){
        System.out.println("****** Speed 6*******");
    }

    public String getName() {
        return name;
    }

    @Override
    void increment() {
        count = count+6;
//        System.out.println("Player6 score: "+count);
    }

    @Override
    void decrement() {
        count = count-3;
//        System.out.println("Player6 score: "+count);
    }


}
