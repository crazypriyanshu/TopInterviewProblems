package org.pdas.LLD.ElevatorSystem;

import org.pdas.LLD.ElevatorSystem.enums.DIRECTIONS;
import org.pdas.LLD.ElevatorSystem.enums.FLOOR_NUMBER;
import org.pdas.LLD.ElevatorSystem.models.Elevator;
import org.pdas.LLD.ElevatorSystem.models.Floor;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance();
        System.out.println("Initialize the elevator system with total floor = "+elevatorSystem.getFloors().size()+ " and total elevators "+elevatorSystem.getElevators().size());
        System.out.println();
        for (Elevator e: elevatorSystem.getElevators()){
            System.out.println(e);
        }

        // Scenario 1
        Floor floor3 = elevatorSystem.getFloors().get(FLOOR_NUMBER.FLOOR_NUMBER_3.ordinal());
        DIRECTIONS direction = DIRECTIONS.UP;
        System.out.println(" ---- User calling UP from floor 3");
        Elevator assignedElevator = elevatorSystem.requestElevator(direction, floor3);

        if (assignedElevator != null){
            assignedElevator.setFloorNumber(FLOOR_NUMBER.FLOOR_NUMBER_3);
            elevatorSystem.openDoor(assignedElevator);
            elevatorSystem.closeDoor(assignedElevator);
            elevatorSystem.selectFloor(FLOOR_NUMBER.FLOOR_NUMBER_5, assignedElevator);

        }

    }
}
