package org.pdas.LLD.TrafficManagement.signal;

import org.pdas.LLD.TrafficManagement.core.LightColor;
import org.pdas.LLD.TrafficManagement.core.TrafficLight;

public class YELLOW_STATE implements SignalState{


    @Override
    public void handle(TrafficLight trafficLight) {
        // in yellow state - we will go to next to green or before Red
        trafficLight.setLightColor(LightColor.YELLOW);
        System.out.println("Start to handle Yellow state of intersectionId: "+trafficLight.getIntersectionId());
    }
}
