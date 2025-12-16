package org.pdas.designPatterns.PLAYGROUND.Command1.commands;

import org.pdas.designPatterns.PLAYGROUND.Command1.Light;

public class SwitchLightCOmmand implements Command {
    private Light light;

    public SwitchLightCOmmand(Light light){
        this.light = light;
        System.out.println("Innitializing Switch light");
    }
    @Override
    public void execute() {
        System.out.println("************Switching ON ACTUAL liGHT******************");
        light.switchLight();
    }
}
