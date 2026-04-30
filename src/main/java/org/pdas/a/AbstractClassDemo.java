package org.pdas.a;

public abstract class AbstractClassDemo {
    public AbstractClassDemo(){
        System.out.println("Abstract Game");
    }
    protected int count = 0;
    abstract void increment();
    abstract void decrement();
    public int getCount(){ return count;}
}
