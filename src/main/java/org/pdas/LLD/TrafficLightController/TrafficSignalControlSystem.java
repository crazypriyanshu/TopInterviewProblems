package org.pdas.LLD.TrafficLightController;

import org.pdas.LLD.TrafficLightController.intersection.IntersectionController;
import org.pdas.LLD.TrafficLightController.observers.CentralMonitor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TrafficSignalControlSystem {
    private static volatile TrafficSignalControlSystem instance;
    private final List<IntersectionController> intersections = new ArrayList<>();
    private ExecutorService executorService;

    private TrafficSignalControlSystem() {
    }

    public void addIntersection(Integer intersectionId, Long greenDuration, Long yellowDuration){
        IntersectionController intersection = new IntersectionController.Builder(intersectionId)
                .withDuration(greenDuration, yellowDuration)
                .addObserver(new CentralMonitor())
                .build();
        intersections.add(intersection);

    }

    public static TrafficSignalControlSystem getInstance(){
        if (instance == null){
            synchronized (TrafficSignalControlSystem.class){
                if (instance == null){
                    instance = new TrafficSignalControlSystem();
                }
            }
        }
        return instance;

    }

    public void startSystem(){
        if (intersections.isEmpty()){
            System.out.println("No intersections to manage. System not starting...");
            return;
        }

        System.out.println("\n ====== Starting Traffic Control System ======= \n");
        executorService = Executors.newFixedThreadPool(intersections.size());
        intersections.forEach(executorService::submit);

    }

    public void stopSystem(){
        System.out.println("Shutting DOWN traffic control system");
        intersections.forEach(IntersectionController::stop);
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)){
                executorService.shutdown();

            }
        } catch (InterruptedException e) {
            executorService.shutdown();
        }

        System.out.println("All intersections stopped");
    }
}
