package org.pdas.LLD.TrafficLightController.states;

import org.pdas.LLD.TrafficLightController.*;

public class RedState implements SignalState {
    @Override
    public void handle(TrafficLight context) {
        context.setCurrentColor(LightColor.RED);
        // Red is a stable state, it transitions to green only when IntersectionController asks it, so next state is self
        context.setNextState(new RedState());

    }
}
