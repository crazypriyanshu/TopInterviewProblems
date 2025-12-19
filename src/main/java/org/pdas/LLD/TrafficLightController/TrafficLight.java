package org.pdas.LLD.TrafficLightController;

import org.pdas.LLD.TrafficLightController.observers.TrafficObserver;
import org.pdas.LLD.TrafficLightController.states.GreenState;
import org.pdas.LLD.TrafficLightController.states.RedState;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight {
    private SignalState currentState;
    private SignalState nextState;
    private LightColor currentColor;
    private final Direction direction;
    private final List<TrafficObserver> observers = new ArrayList<>();
    private final Integer intersectionId;
    public TrafficLight(Integer intersectionId, Direction direction) {
        this.currentState = new RedState();
        this.direction = direction;
        this.intersectionId = intersectionId;
        this.currentState.handle(this);
    }

    public void startGreen(){
        this.currentState = new GreenState();
        this.currentState.handle(this);
    }

    public void transition(){
        this.currentState = nextState;
        this.currentState.handle(this);
        notifyObservers();
    }

    public SignalState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(SignalState currentState) {
        this.currentState = currentState;
    }

    public SignalState getNextState() {
        return nextState;
    }

    public void setNextState(SignalState nextState) {
        this.nextState = nextState;
    }

    public LightColor getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(LightColor color) {
        if (this.currentColor != color){
            this.currentColor = color;

        }
    }

    // Observer pattern methods
    public void addObserver(TrafficObserver observer){
        observers.add(observer);
    }

    public void removeObserver(TrafficObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(){
        for (TrafficObserver observer: observers){
            observer.update(intersectionId, direction, currentColor);
        }
    }

    public Direction getDirection() {
        return direction;
    }

    public List<TrafficObserver> getObservers() {
        return observers;
    }

    public Integer getIntersectionId() {
        return intersectionId;
    }
}
