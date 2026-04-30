package org.pdas.arrays.mostAskedProblems.elevator;

public class Door {
    DoorState doorState;
    int elevatorId;
    int floor;

    public Door(int elevatorId){
        this.doorState = DoorState.CLOSED;
        this.elevatorId = elevatorId;
        this.floor = 0;
    }

    public void openDoor(int floorNumber) throws InterruptedException {

        System.out.println("Opening Door for floor: "+floorNumber);
        doorState = DoorState.OPENING;
        Thread.sleep(1000);
        doorState = DoorState.OPEN;
    }
    public void closeDoor(int floorNumber) throws InterruptedException {
        System.out.println("Closing Door for floor"+floorNumber);
        doorState = DoorState.CLOSING;
        Thread.sleep(1000);
        doorState = DoorState.CLOSED;
    }
}
