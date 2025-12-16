package org.pdas.designPatterns.PLAYGROUND.Command1;

public class FloorLamp {
    private Light light;
    public FloorLamp(){
        this.light = new Light();
    }
    public void switchLight(){
        System.out.println("Switching floorLights");
        light.switchLight();
    }
}
