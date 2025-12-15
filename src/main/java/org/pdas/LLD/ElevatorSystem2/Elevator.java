package org.pdas.LLD.ElevatorSystem2;

import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Elevator implements Runnable{
    private final int id;
    private int currentFloor = 1;
    private DIRECTION direction;
    private ELEVATOR_STATUS elevatorStatus;

    // A thread-safe queue for internal requests (buttons pressed inside the car)
    private final PriorityQueue<Integer> internalRequest;
    // A thread safe queue for external Request
    private final ConcurrentLinkedQueue<Request> externalRequest;

    public Elevator (int id){
        this.id = id;
        this.internalRequest = new PriorityQueue<>();
        this.externalRequest = new ConcurrentLinkedQueue<>();
        System.out.println("Elevator id "+id + " initialized for floor = 1");
    }

    public void addRequest(Request request){
        if (request.isInternal()){
            internalRequest.add(request.getFloor());
        } else {
            externalRequest.add(request);
        }
        System.out.println("Elevator id : "+id + " received : "+request);
    }

    private void processRequest(){
        if (internalRequest.isEmpty() && externalRequest.isEmpty()){
            elevatorStatus = ELEVATOR_STATUS.STOPPED;
            direction = DIRECTION.IDLE;
            return;
        }

        int targetFloor = findNextTargetFloor();
        if (targetFloor == currentFloor){
            stopAndOpenDoor(currentFloor);
            removeCompletedRequest(currentFloor);
        } else {
            move(targetFloor);
        }
    }

    private void move(int targetFloor){
        if (targetFloor > currentFloor){
            direction = DIRECTION.UP;
            currentFloor++;
        } else if (targetFloor < currentFloor) {
            direction = DIRECTION.DOWN;
            currentFloor--;
        }
        elevatorStatus = ELEVATOR_STATUS.MOVING;
        System.out.printf("--- Elevator %d: Moving %s to Floor %d (Target: %d) ---\n",
                id, direction, currentFloor, targetFloor);
    }

    private void stopAndOpenDoor(int currentFloor){
        elevatorStatus = ELEVATOR_STATUS.DOORS_OPEN;
        System.out.println("Elevator stopped at floor "+currentFloor+" Doors are opening...");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        elevatorStatus = ELEVATOR_STATUS.STOPPED;
        System.out.println("Elevator "+ id+" stopped at floor "+ currentFloor);
        return;
    }

    private void removeCompletedRequest(int currentFloor){
        internalRequest.remove(currentFloor);
        externalRequest.removeIf(request -> request.getFloor() == currentFloor);
    }

    private int findNextTargetFloor(){
        // prioritize internal request
        if (!internalRequest.isEmpty()){
            return internalRequest.peek();
        } else if (!externalRequest.isEmpty()) {
            return externalRequest.peek().getFloor();
        }
        return currentFloor;
    }
    @Override
    public void run() {
        while (true){
            try {
                processRequest();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public int getId() {
        return id;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public DIRECTION getDirection() {
        return direction;
    }

    public void setDirection(DIRECTION direction) {
        this.direction = direction;
    }

    public ELEVATOR_STATUS getElevatorStatus() {
        return elevatorStatus;
    }

    public void setElevatorStatus(ELEVATOR_STATUS elevatorStatus) {
        this.elevatorStatus = elevatorStatus;
    }

    public PriorityQueue<Integer> getInternalRequest() {
        return internalRequest;
    }

    public ConcurrentLinkedQueue<Request> getExternalRequest() {
        return externalRequest;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "id=" + id +
                ", currentFloor=" + currentFloor +
                ", direction=" + direction +
                ", elevatorStatus=" + elevatorStatus +
                ", internalRequest=" + internalRequest +
                ", externalRequest=" + externalRequest +
                '}';
    }
}