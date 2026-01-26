package org.pdas.LLD.TrafficManagement.signal;

import org.pdas.LLD.TrafficManagement.core.TrafficLight;

public interface SignalState {
    public void handle(TrafficLight context);
}
