package org.pdas.LLD.ElevatorSystem.models;

public class ElevatorButton extends Button {
    private boolean status;
    private Integer floorNumber;

    public ElevatorButton(boolean status, Integer floorNumber){
        this.status = status;
        this.floorNumber = floorNumber;
    }

    @Override
    public boolean isPressed() {
        return this.status;
    }

    @Override
    public boolean press() {
        this.status = !status;
        return status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }
}
