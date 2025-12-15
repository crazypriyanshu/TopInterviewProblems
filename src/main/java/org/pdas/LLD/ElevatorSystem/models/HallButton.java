package org.pdas.LLD.ElevatorSystem.models;

import org.pdas.LLD.ElevatorSystem.enums.DIRECTIONS;
import org.pdas.LLD.ElevatorSystem.interfaces.Button;

public class HallButton implements Button {
    private boolean status;
    private DIRECTIONS direction;

    public HallButton(boolean status, DIRECTIONS direction){
        this.status = status;
        this.direction = direction;
    }

    public DIRECTIONS getDirection() {
        return direction;
    }

    public void setDirection(DIRECTIONS direction) {
        this.direction = direction;
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
