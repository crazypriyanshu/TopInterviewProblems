package org.pdas.LLD.TrafficLightController.states;

import org.pdas.LLD.TrafficLightController.*;

public class GreenState implements SignalState {
    @Override
    public void handle(TrafficLight context) {
        context.setCurrentColor(LightColor.GREEN);
        context.setNextState(new YellowState());

    }
}
