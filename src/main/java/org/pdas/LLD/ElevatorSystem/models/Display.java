package org.pdas.LLD.ElevatorSystem.models;

import org.pdas.LLD.ElevatorSystem.enums.DIRECTIONS;
import org.pdas.LLD.ElevatorSystem.enums.FLOOR_NUMBER;

public class Display {
    private FLOOR_NUMBER floorNumber;
    private DIRECTIONS direction;

    private int weight;

    public Display(FLOOR_NUMBER floorNumber, DIRECTIONS direction, Integer weight){
        this.floorNumber = floorNumber;
        this.direction = direction;
        this.weight = weight;
    }
    public Display(){}

    public FLOOR_NUMBER getFloorNumber(){
        return floorNumber;
    }
    public void setFloorNumber(FLOOR_NUMBER floorNumber){
        this.floorNumber = floorNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public DIRECTIONS getDirection() {
        return direction;
    }

    public void setDirection(DIRECTIONS direction) {
        this.direction = direction;
    }

}
