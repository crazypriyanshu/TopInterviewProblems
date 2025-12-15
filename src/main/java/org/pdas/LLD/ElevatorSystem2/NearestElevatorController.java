package org.pdas.LLD.ElevatorSystem2;

import java.util.List;
import java.util.Locale;

public class NearestElevatorController implements ElevatorController{
    @Override
    public void assignRequest(Request request, List<Elevator> elevators) {
        // simple strategy
        // simple strategy : find elevator that is closest and idle/moving towards the request
        Elevator bestElevator = null;
        Long minDistance = Long.MAX_VALUE;
        for (Elevator elevator : elevators){
            long distance = Math.abs(request.getFloor() - elevator.getCurrentFloor());
            if (distance < minDistance){
                minDistance = distance;
                bestElevator = elevator;
            }

        }
        if (bestElevator != null){
            System.out.println("Controller assigned request "+request+" to elevator"+bestElevator);
            bestElevator.addRequest(request);
        } else {
            System.out.println("No elevator to serve request");
        }
    }
}
