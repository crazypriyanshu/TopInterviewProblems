package org.pdas.arrays.mostAskedProblems.elevator;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller Singleton class - ElevatorManager is responsible for creating Elevators and running them.
 * Add elevator
 * goToFloor
 *
 * */
public class ElevatorManager {
    private static volatile ElevatorManager instance = null;
    private final ArrayList<Elevator> elevators = new ArrayList<>();


    private ElevatorManager(int n){
        // initialize 8 Elevators
        for (int i = 0; i < n; i++) {
            elevators.add(new Elevator(i));
        }
    }

    /**
     * 8 Elevator setup
     * */
    public ElevatorManager getInstance(){
        if (instance == null){
            synchronized (ElevatorManager.class){
                instance = new ElevatorManager(8);
            }
        }
        return instance;
    }

    /**
     * Handle the request
     * */
    public synchronized void processRequest(Integer sourceFloor, Integer destinationFloor){
        if (sourceFloor == null || destinationFloor == null) return;
        System.out.println("Received request from floorNumber: "+sourceFloor+" to floor: "+destinationFloor);


    }

}
