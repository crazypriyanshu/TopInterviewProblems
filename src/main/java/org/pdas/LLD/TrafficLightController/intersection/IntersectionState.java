package org.pdas.LLD.TrafficLightController.intersection;

public interface IntersectionState {
    void handle(IntersectionController context) throws InterruptedException;
}
