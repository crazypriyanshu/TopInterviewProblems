package org.pdas.LLD.TrafficManagement;

import org.pdas.LLD.TrafficManagement.core.DIRECTIONS;
import org.pdas.LLD.TrafficManagement.intersection.IntersectionController;
import org.pdas.LLD.TrafficManagement.observers.CentralObserver;

public class Client {
    public static void main(String[] args) {
        IntersectionController intersection = new IntersectionController.Builder(1L)
                .withDuration(10, 3)
                .addGlobalObserver(new CentralObserver())
                .addRoad(1, DIRECTIONS.NORTH)
                .addRoad(2, DIRECTIONS.SOUTH)
                .addRoad(3, DIRECTIONS.EAST)
                .addRoad(4, DIRECTIONS.WEST)
                .addPhase(1, 2) // road 1 and 2 (North- south)
                .addPhase(3, 4) // road 3, 4 (East - west)
                .build();
        Thread intersectionThread = new Thread();
        intersectionThread.start();
        System.out.println(intersection.getAllLights());
        System.out.println(intersection.isEmergency());
        intersection.triggerEmergency();
        System.out.println(intersection.getNextPhase());
    }
}
