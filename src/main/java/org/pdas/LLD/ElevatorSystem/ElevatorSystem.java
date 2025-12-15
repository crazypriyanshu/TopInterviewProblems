package org.pdas.LLD.ElevatorSystem;

import org.pdas.LLD.ElevatorSystem.enums.DIRECTIONS;
import org.pdas.LLD.ElevatorSystem.enums.ELEVATOR_NUMBER;
import org.pdas.LLD.ElevatorSystem.enums.FLOOR_NUMBER;
import org.pdas.LLD.ElevatorSystem.models.*;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    private List<Elevator> elevators;
    private List<Floor> floors;

    private ElevatorSystem(){
        this.elevators = new ArrayList<>();
        this.floors = new ArrayList<>();
        // create 3 elevators
        for (int i = 1 ; i <= 3; i++){
            this.elevators.add(new Elevator(i));
        }
        for (FLOOR_NUMBER floorNumber: FLOOR_NUMBER.values()){
            this.floors.add(new Floor(floorNumber, new OusidePanel()));
        }


    }

    public List<Elevator> getElevators() {
        return elevators;
    }

    private static volatile ElevatorSystem elevatorSystemInstance;
    public static ElevatorSystem getInstance(){
        // Singleton Double Locking
        if (elevatorSystemInstance == null){
            synchronized (ElevatorSystem.class){
                if (elevatorSystemInstance == null){
                    elevatorSystemInstance = new ElevatorSystem();
                }
            }
        }
        return elevatorSystemInstance;
    }

    public Elevator requestElevator(DIRECTIONS direction, Floor floor){
        if (elevators == null || elevators.isEmpty()){
            System.out.println("No elevators initialized");
            return null;
        }
        int targetFloor = floor.getFloorNumber().ordinal();
        Elevator bestElevator = null;
        int minTime = Integer.MAX_VALUE;
        for (Elevator elevator: elevators){
            int time = elevator.calculateServiceTime(targetFloor, direction);
            if (time < minTime){
                minTime = time;
                bestElevator = elevator;
            }
        }
        if (bestElevator != null){
            System.out.println("Dispatching "+ bestElevator + " to pick request on floor "+ targetFloor + " going in direction "+direction);
            bestElevator.setCurrentDirection(direction);
        }
        return bestElevator;


    }

    public void openDoor(Elevator elevator){
        elevator.getDoor().openDoor();
    }

    public void closeDoor(Elevator elevator){
        elevator.getDoor().closeDoor();
    }

    public void selectFloor(FLOOR_NUMBER floorNumber, Elevator elevator){
        elevator.getInsidePanel().pressFloorButton(floorNumber.ordinal());
    }


    public void setElevators(List<Elevator> elevators) {
        this.elevators = elevators;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
