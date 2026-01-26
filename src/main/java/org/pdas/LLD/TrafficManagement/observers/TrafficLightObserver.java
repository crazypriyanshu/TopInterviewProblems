package org.pdas.LLD.TrafficManagement.observers;

import org.pdas.LLD.TrafficManagement.core.DIRECTIONS;
import org.pdas.LLD.TrafficManagement.core.LightColor;

public interface TrafficLightObserver {
    public void update(Long intersectionId, DIRECTIONS direction, LightColor color);
}
