package org.pdas.LLD.TrafficManagement.intersection;

import org.pdas.LLD.TrafficManagement.signal.GREEN_STATE;
import org.pdas.LLD.TrafficManagement.signal.RED_STATE;
import org.pdas.LLD.TrafficManagement.signal.YELLOW_STATE;

import java.util.List;

public class ActivePhaseState implements IntersectionState{
    @Override
    public void handle(IntersectionController activeState) {
        List<Integer> activeRoads = activeState.getNextPhase();

        // 1. Turn active to GREEN
        for (Integer roadNumber: activeRoads){
            activeState.getLight(roadNumber).setCurrentState(new GREEN_STATE());// we need to transition to next state
        }
        activeState.smartWait(activeState.getGreenDurationInSecs());

        // 2. Turn active to yellow
        for (Integer roadNumber: activeRoads){
            activeState.getLight(roadNumber).setCurrentState(new YELLOW_STATE());
        }
        activeState.smartWait(activeState.getYellowDurationInSecs());

        // 3. Transition to red
        for (Integer roadNumber: activeRoads){
            activeState.getLight(roadNumber).setCurrentState(new RED_STATE());
        }
    }
}
