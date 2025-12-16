package org.pdas.designPatterns.PLAYGROUND.Command1;

public class Kitchen extends Room{
    private Oven oven;
    public Kitchen(){
        System.out.println("Kitchen adding");
        this.oven = new Oven();
    }
}
