package org.pdas.LLD.ElevatorSystem.models;

import org.pdas.LLD.ElevatorSystem.enums.DOOR_ACTION;
import org.pdas.LLD.ElevatorSystem.interfaces.Button;

public class DoorButtons implements Button {
    private boolean status;
    private DOOR_ACTION doorAction;

    public DoorButtons(boolean status, DOOR_ACTION doorAction){
        this.status = status;
        this.doorAction = doorAction;
    }

    public DOOR_ACTION getDoorAction() {
        return doorAction;
    }

    public void setDoorAction(DOOR_ACTION doorAction) {
        this.doorAction = doorAction;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public boolean isPressed() {
        return status;
    }

    @Override
    public boolean press() {
        status = !status;
        return status;
    }
}
