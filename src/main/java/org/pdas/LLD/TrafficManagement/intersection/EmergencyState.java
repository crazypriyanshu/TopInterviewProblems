package org.pdas.LLD.TrafficManagement.intersection;

import org.pdas.LLD.TrafficManagement.core.LightColor;
import org.pdas.LLD.TrafficManagement.core.TrafficLight;
import org.pdas.LLD.TrafficManagement.signal.RED_STATE;

public class EmergencyState implements IntersectionState{
    @Override
    public void handle(IntersectionController emergencyState) {
        System.out.println("!!! EMERGENCY MODE ACTIVE - ALL ROADS RED !!!");
        for (TrafficLight trafficLight: emergencyState.getAllLights().values()){
            System.out.println("EMERGENCY: setting trafficLight RED for intersectionId: "+trafficLight.getIntersectionId()+" for direction: "+trafficLight.getDirection());
            trafficLight.setLightColor(LightColor.RED);
            trafficLight.setNextState(new RED_STATE());
        }
        while (emergencyState.isEmergency()){
            emergencyState.smartWait(1);
        }

    }
}
