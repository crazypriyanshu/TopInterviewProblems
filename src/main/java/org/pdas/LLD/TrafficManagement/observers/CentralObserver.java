package org.pdas.LLD.TrafficManagement.observers;

import org.pdas.LLD.TrafficManagement.core.DIRECTIONS;
import org.pdas.LLD.TrafficManagement.core.LightColor;

public class CentralObserver implements TrafficLightObserver{
    @Override
    public void update(Long intersectionId, DIRECTIONS direction, LightColor color) {
        System.out.printf("[CENTRAL-MONITOR] Intersection %d: Light for %s direction changed to %s. \n", intersectionId, direction, color);
    }
}
