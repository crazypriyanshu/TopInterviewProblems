package org.pdas.LLD.ElevatorSystem2;

import java.util.List;

public interface ElevatorController {
    void assignRequest(Request request, List<Elevator> elevators);
}
