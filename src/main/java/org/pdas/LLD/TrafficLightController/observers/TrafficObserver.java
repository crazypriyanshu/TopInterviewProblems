package org.pdas.LLD.TrafficLightController.observers;

import org.pdas.LLD.TrafficLightController.Direction;
import org.pdas.LLD.TrafficLightController.LightColor;

public interface TrafficObserver {
    void update(int intersectionId, Direction direction, LightColor lightColor);
}
