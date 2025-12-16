package org.pdas.designPatterns.PLAYGROUND.Command1;

public class Light {
    private boolean switchedOn;
    public boolean isSwitchedOn(){
        System.out.println("Current status is : "+ switchedOn);
        return switchedOn;
    }
    public void setSwitchedOn(boolean switchedOn){
        System.out.println("Making Light "+switchedOn);
        this.switchedOn = switchedOn;
    }

    public void switchLight(){
        System.out.println("Setting light from: "+switchedOn+" to : "+!switchedOn);
        switchedOn = !switchedOn;
    }
}
