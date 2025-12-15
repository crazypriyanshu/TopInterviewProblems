package org.pdas.LLD.ElevatorSystem2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance(2, 10);
        elevatorSystem.submitRequest(new Request(5, DIRECTION.UP, false));
        elevatorSystem.submitRequest(new Request(2, DIRECTION.DOWN, false));
        Thread.sleep(1000);
        // someone gets in and adds request
        elevatorSystem.elevators.get(0).addRequest(new Request(10, DIRECTION.UP, true));
        elevatorSystem.submitRequest(new Request(9, DIRECTION.DOWN, false));
        elevatorSystem.shutDown();


    }
}
