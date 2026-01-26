package org.pdas.LLD.TrafficManagement.signal;

import org.pdas.LLD.TrafficManagement.core.LightColor;
import org.pdas.LLD.TrafficManagement.core.TrafficLight;

public class GREEN_STATE implements SignalState{


    @Override
    public void handle(TrafficLight trafficLight) {
        // in green state what we need to do, we need to allow traffic signal
        System.out.println("Start to handle Green state of intersectionId: "+trafficLight.getIntersectionId());
        trafficLight.setLightColor(LightColor.GREEN);
    }
}
