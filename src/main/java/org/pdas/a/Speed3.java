package org.pdas.a;

public class Speed3 extends AbstractClassDemo{
    public final String name = "Player3";
    public Speed3(){
        System.out.println("**Speed 3**");
    }

    public String getName() {
        return name;
    }

    @Override
    void increment() {
        count = count+3;
//        System.out.println("Player3 score: "+count);
    }

    @Override
    void decrement() {
        count = count-1;
//        System.out.println("Player3 score: "+count);
    }


}
