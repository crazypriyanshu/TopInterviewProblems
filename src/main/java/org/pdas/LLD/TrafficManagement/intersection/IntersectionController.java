package org.pdas.LLD.TrafficManagement.intersection;


import org.pdas.LLD.TrafficLightController.Direction;
import org.pdas.LLD.TrafficLightController.observers.TrafficObserver;
import org.pdas.LLD.TrafficManagement.core.DIRECTIONS;
import org.pdas.LLD.TrafficManagement.core.TrafficLight;
import org.pdas.LLD.TrafficManagement.observers.TrafficLightObserver;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IntersectionController implements Runnable {
    private final Long controllerId;
    private final Map<Integer, TrafficLight> roadMap; // roadNumber -> Light
    private final List<List<Integer>> phases; // User-defined groups of road numbers
    private int currentPhaseIndex = 0;
    private int greenDurationInSecs;
    private int yellowDurationInSecs;
    private volatile boolean isRunning = true;
    private volatile boolean isEmergency = false;
    private IntersectionState currentState;

    private final Lock lock = new  ReentrantLock();
    private final Condition timerCondition = lock.newCondition();

    public IntersectionController(Long controllerId, Map<Integer, TrafficLight> roadMap, List<List<Integer>> phases, int greenDurationInSecs, int yellowDurationInSecs) {
        this.controllerId = controllerId;
        this.roadMap = roadMap;
        this.phases = phases;
        this.greenDurationInSecs = greenDurationInSecs;
        this.yellowDurationInSecs = yellowDurationInSecs;
        this.currentState = new ActivePhaseState(); // starting with Active phase

    }

    public void triggerEmergency(){
        lock.lock();
        try {
            this.isEmergency = true;
            timerCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void smartWait(long durationInSec){
        lock.lock();
        try {
            System.out.println("Smart Wait: , waiting for "+ durationInSec);
            timerCondition.await(durationInSec, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public boolean isEmergency() {
        return isEmergency;
    }

    public List<Integer> getNextPhase(){
        List<Integer> phase = phases.get(currentPhaseIndex);
        currentPhaseIndex = (currentPhaseIndex+1)%phases.size();
        return phase;
    }

    public TrafficLight getLight(Integer roadNumber){
        return roadMap.get(roadNumber);
    }

    public Map<Integer, TrafficLight> getAllLights(){
        return roadMap;
    }

    public int getGreenDurationInSecs() {
        return greenDurationInSecs;
    }

    public int getYellowDurationInSecs() {
        return yellowDurationInSecs;
    }

    @Override
    public void run() {
        while (isRunning){
            try {
                if (isEmergency){
                    new EmergencyState().handle(this);

                } else {
                    currentState.handle(this);
                }
            } catch (RuntimeException e){
                Thread.currentThread().interrupt();
                break;
            }
        }

    }

    public static class Builder{
        private final Long id;
        private int greenDuration;
        private int yellowDuration;
        private final List<TrafficLightObserver> observers = new ArrayList<>();
        private final Map<Integer, TrafficLight> roadMap = new HashMap<>();
        private final List<List<Integer>> phases = new ArrayList<>();

        public Builder(Long id){
            this.id = id;
        }

        public Builder withDuration(int greenDuration, int yellowDuration){
            this.greenDuration = greenDuration;
            this.yellowDuration = yellowDuration;
            return this;
        }

        public Builder addObservers(TrafficLightObserver observer){
            this.observers.add(observer);
            return this;
        }

        public Builder addRoad(Integer roadNumber, DIRECTIONS direction){
            TrafficLight light = new TrafficLight(id, direction);
            for (TrafficLightObserver observer: observers){
                light.addObserver(observer);

            }
            this.roadMap.put(roadNumber, light);
            return this;
        }

        /**
         * Defines a group of roads that should be GREEN at the same time.
         */
        public Builder addPhase(Integer... roadNumbers){
            phases.add(Arrays.asList(roadNumbers));
            return this;
        }

        public Builder addGlobalObserver(TrafficLightObserver observer){
            this.observers.add(observer);
            for (TrafficLight light: roadMap.values()){
                light.addObserver(observer);
            }
            return this;
        }

        public IntersectionController build(){
            for (List<Integer> phase: phases){
                for (Integer roadNum: phase){
                    if (!roadMap.containsKey(roadNum)){
                        throw new IllegalStateException("Phase contains this road "+ roadNum+ " which was not added to builder");

                    }
                }
            }
            if (phases.isEmpty()){
                throw new IllegalStateException("Intersection must have at least one traffic phase");
            }
            return new IntersectionController(id, roadMap, phases,greenDuration, yellowDuration);

        }
    }
}
