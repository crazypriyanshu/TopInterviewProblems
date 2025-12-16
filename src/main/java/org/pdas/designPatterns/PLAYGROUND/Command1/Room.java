package org.pdas.designPatterns.PLAYGROUND.Command1;

import org.pdas.designPatterns.PLAYGROUND.Command1.commands.Command;

public class Room {
    private Light light;
    Command command;
    public Room(){
        this.light = new Light();
    }
    public void setCommand(Command command){
        System.out.println("setting command : "+command);
        this.command = command;
    }

    public void executeCommand(){
        command.execute();
    }
}
