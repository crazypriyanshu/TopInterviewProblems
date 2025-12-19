package org.pdas.LLD.TrafficLightController.states;

import org.pdas.LLD.TrafficLightController.*;

public class YellowState implements SignalState {
    @Override
    public void handle(TrafficLight context) {
        context.setCurrentColor(LightColor.YELLOW);
        context.setNextState(new RedState());

    }
}
