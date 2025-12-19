package org.pdas.LLD.TrafficLightController.observers;

import org.pdas.LLD.TrafficLightController.Direction;
import org.pdas.LLD.TrafficLightController.LightColor;

public class CentralMonitor implements TrafficObserver{
    @Override
    public void update(int intersectionId, Direction direction, LightColor lightColor) {
        System.out.printf("[MONITOR] Intersection %d: Light for %s direction changed to %s. \n", intersectionId, direction, lightColor);
    }
}
