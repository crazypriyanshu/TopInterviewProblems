package org.pdas.LLD.TrafficLightController;

import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        TrafficSignalControlSystem controlSystem = TrafficSignalControlSystem.getInstance();
        controlSystem.addIntersection(1, 5000L, 2000L);
        controlSystem.addIntersection(2, 3000L, 1000L);
        controlSystem.startSystem();
        try {
            TimeUnit.SECONDS.sleep(20L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        controlSystem.stopSystem();
    }
}
