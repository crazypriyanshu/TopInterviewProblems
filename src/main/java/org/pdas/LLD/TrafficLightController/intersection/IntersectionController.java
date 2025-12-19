package org.pdas.LLD.TrafficLightController.intersection;

import org.pdas.LLD.SnakeLadderGame.Game;
import org.pdas.LLD.TrafficLightController.Direction;
import org.pdas.LLD.TrafficLightController.TrafficLight;
import org.pdas.LLD.TrafficLightController.observers.TrafficObserver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionController implements Runnable{
    private final Integer id;
    private final Map<Direction, TrafficLight> trafficLights;
    private IntersectionState currentState;
    private final Long greenDuration;
    private final Long yellowDuration;
    private volatile boolean isRunning = true;

    // Objects are created with Builder of this class

    public IntersectionController(Integer id, Map<Direction, TrafficLight> trafficLights, Long greenDuration, Long yellowDuration) {
        this.id = id;
        this.trafficLights = trafficLights;
        this.greenDuration = greenDuration;
        this.yellowDuration = yellowDuration;
        // initial state for Intersection
        this.currentState = new NorthSouthGreenState();
    }

    @Override
    public void run() {
        while (isRunning){
            try {
                currentState.handle(this);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Intersection id: "+id+" has been interrupted");
                isRunning = false;
            }
        }

    }

    public TrafficLight getLight(Direction direction){
        return trafficLights.get(direction);
    }

    public void stop(){
        this.isRunning = false;
    }

    public Integer getId() {
        return id;
    }

    public Map<Direction, TrafficLight> getTrafficLights() {
        return trafficLights;
    }

    public IntersectionState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(IntersectionState currentState) {
        this.currentState = currentState;
    }

    public Long getGreenDuration() {
        return greenDuration;
    }

    public Long getYellowDuration() {
        return yellowDuration;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public static class Builder {
        private final Integer id;
        private Long greenDuration = 15000L;
        private Long yellowDuration = 3000L;
        private final List<TrafficObserver> observers = new ArrayList<>();

        public Builder(Integer id){
            this.id = id;
        }

        public Builder withDuration(Long greenDuration, Long yellowDuration){
            this.greenDuration = greenDuration;
            this.yellowDuration = yellowDuration;
            return this;
        }

        public Builder addObserver(TrafficObserver observer){
            this.observers.add(observer);
            return this;
        }

        public IntersectionController build(){
            Map<Direction, TrafficLight> lights = new HashMap<>();
            for (Direction direction: Direction.values()){
                TrafficLight trafficLight = new TrafficLight(id, direction);
                // now also attach the observers
                observers.forEach(trafficLight::addObserver);
                lights.put(direction, trafficLight);
            }
            return new IntersectionController(id, lights, greenDuration, yellowDuration);
        }

    }
}
