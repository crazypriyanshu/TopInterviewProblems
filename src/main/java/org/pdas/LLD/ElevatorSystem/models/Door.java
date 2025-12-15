package org.pdas.LLD.ElevatorSystem.models;

import org.pdas.LLD.ElevatorSystem.enums.DOOR_ACTION;

public class Door {
    private DOOR_ACTION doorAction;
    public Door(DOOR_ACTION doorAction){
        this.doorAction = doorAction;
    }

    public Door() {}


    public void openDoor(){
        doorAction = DOOR_ACTION.OPEN;
        System.out.println("Opening Door");
    }

    public void closeDoor(){
        doorAction = DOOR_ACTION.CLOSED;
        System.out.println("Closing Door");
    }
}
