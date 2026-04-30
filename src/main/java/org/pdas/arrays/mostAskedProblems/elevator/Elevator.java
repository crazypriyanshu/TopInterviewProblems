package org.pdas.arrays.mostAskedProblems.elevator;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Elevator {
    int count = new AtomicInteger(0).addAndGet(1);
    private int id;
    private String name;
    int currentFloor;
    private ELEVATOR_STATUS elevatorStatus;
    private Door door;
    private List<ButtonListener> buttonListeners;


    public Elevator(int id){
        this.id = id;
        this.name = "Elevator-"+id;
        this.door = new Door(id);

    }

}
