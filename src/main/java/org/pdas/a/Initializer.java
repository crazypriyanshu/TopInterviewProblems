package org.pdas.a;

public class Initializer extends AbstractClassDemo{
    Initializer(){
        System.out.println("Just initialized "+count);
    }
    @Override
    void increment() {
        System.out.println("increment "+count);
        count = count;
    }

    @Override
    void decrement() {
        System.out.println("decrement "+count);
        count = count;
    }
}
