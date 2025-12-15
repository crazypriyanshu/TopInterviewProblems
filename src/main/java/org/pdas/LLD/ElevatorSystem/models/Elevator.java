package org.pdas.LLD.ElevatorSystem.models;

import org.pdas.LLD.ElevatorSystem.enums.DIRECTIONS;
import org.pdas.LLD.ElevatorSystem.enums.ELEVATOR_NUMBER;
import org.pdas.LLD.ElevatorSystem.enums.FLOOR_NUMBER;

public class Elevator {

    private ELEVATOR_NUMBER elevatorNumber;
    private Door door;
    private InsidePanel insidePanel;
    private Display display;
    private FLOOR_NUMBER floorNumber;
    private DIRECTIONS currentDirection;

    public Elevator(ELEVATOR_NUMBER elevatorNumber, Door door, InsidePanel insidePanel, Display display, FLOOR_NUMBER currentFloorNumber, DIRECTIONS currentDirection){
        this.elevatorNumber = elevatorNumber;
        this.door = door;
        this.insidePanel = insidePanel;
        this.display = display;
        this.floorNumber = currentFloorNumber;
        this.currentDirection = currentDirection;
    }

    public Elevator(int id){
        this.elevatorNumber = ELEVATOR_NUMBER.ELEVATOR_NUMBER_A;
        this.door = new Door();
        this.insidePanel = new InsidePanel();
        this.currentDirection = DIRECTIONS.IDLE;
        this.floorNumber = FLOOR_NUMBER.FLOOR_NUMBER_1;
    }

    public int calculateServiceTime(int targetFloor, DIRECTIONS requestedDirection){
        int distance = Math.abs(this.floorNumber.ordinal() - targetFloor);
        if (this.currentDirection == DIRECTIONS.IDLE){
            return distance;
        }
        if (this.currentDirection == requestedDirection){
            // if elevator is already moving in this direction
            if (requestedDirection == DIRECTIONS.UP && targetFloor >= this.floorNumber.ordinal()) {
                return distance;
            } else if (requestedDirection == DIRECTIONS.DOWN && targetFloor <= this.floorNumber.ordinal()) {
                return distance;
            }
        }
        return distance+100; // large value

    }

    @Override
    public String toString() {
        return "Elevator{" +
                "elevatorNumber=" + elevatorNumber +
                ", door=" + door +
                ", insidePanel=" + insidePanel +
                ", display=" + display +
                ", floorNumber=" + floorNumber +
                ", currentDirection=" + currentDirection +
                '}';
    }

    public ELEVATOR_NUMBER getElevatorNumber() {
        return elevatorNumber;
    }

    public void setElevatorNumber(ELEVATOR_NUMBER elevatorNumber) {
        this.elevatorNumber = elevatorNumber;
    }

    public DIRECTIONS getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(DIRECTIONS currentDirection) {
        this.currentDirection = currentDirection;
    }

    public FLOOR_NUMBER getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(FLOOR_NUMBER floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public InsidePanel getInsidePanel() {
        return insidePanel;
    }

    public void setInsidePanel(InsidePanel insidePanel) {
        this.insidePanel = insidePanel;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
}

