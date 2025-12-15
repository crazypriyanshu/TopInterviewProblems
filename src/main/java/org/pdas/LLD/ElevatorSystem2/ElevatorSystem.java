package org.pdas.LLD.ElevatorSystem2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorSystem {
    private static ElevatorSystem instance;
    public final List<Elevator> elevators;
    private final ElevatorController controller;
    private final ExecutorService executorService;
    private final int maxFloor;

    private ElevatorSystem(int numberOfElevators, int maxFloor){
        this.maxFloor = maxFloor;
        this.elevators = new ArrayList<>(maxFloor);
        this.controller = new NearestElevatorController();
        this.executorService = Executors.newFixedThreadPool(numberOfElevators);

        for (int i = 0; i < numberOfElevators; i++){
            Elevator elevator = new Elevator(i);
            elevators.add(elevator);
            executorService.execute(elevator);
        }
        System.out.println("Elevator system initialized with "+numberOfElevators+ " lifts initialized");
    }

    public static synchronized ElevatorSystem getInstance(int numberOfElevators, int maxFloor){
        if (instance == null){
            instance = new ElevatorSystem(numberOfElevators, maxFloor);
        }
        return instance;
    }

    public void submitRequest(Request request){
        if (request.getFloor() < 1){
            System.out.println("Error : floor cant be "+request.getFloor());
            return;
        }
        controller.assignRequest(request, elevators);
    }
    public void shutDown(){
        executorService.shutdown();
    }

}
