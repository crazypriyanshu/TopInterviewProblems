package org.pdas.LLD.TrafficManagement.core;

import org.pdas.LLD.TrafficLightController.observers.TrafficObserver;
import org.pdas.LLD.TrafficManagement.observers.TrafficLightObserver;
import org.pdas.LLD.TrafficManagement.signal.GREEN_STATE;
import org.pdas.LLD.TrafficManagement.signal.RED_STATE;
import org.pdas.LLD.TrafficManagement.signal.SignalState;
import org.pdas.LLD.TrafficManagement.signal.YELLOW_STATE;

import java.util.ArrayList;
import java.util.List;

public class TrafficLight {
    private SignalState currentState;
    private SignalState nextState;
    private LightColor lightColor;
    private final DIRECTIONS direction;
    private final Long intersectionId;
    private final List<TrafficLightObserver> observers = new ArrayList<>();

    //
    public TrafficLight(LightColor lightColor, DIRECTIONS direction, Long intersectionId) {
        System.out.println("Instantiating Traffic Light in RED(default), in direction: "+direction+ " intersectionId: "+intersectionId);
        this.currentState = new RED_STATE();
        this.lightColor = lightColor;
        this.direction = direction;
        this.intersectionId = intersectionId;
        currentState.handle(this);
    }

    // we should be able to create a traffic light using intersectionId and the direction which it points to
    public TrafficLight(Long intersectionId, DIRECTIONS direction){
        System.out.println("Instantiating Traffic Light in RED(default), in direction: "+direction+ " intersectionId: "+intersectionId);
        this.intersectionId = intersectionId;
        this.direction = direction;
        this.currentState = new RED_STATE();
        this.lightColor = LightColor.RED;
    }

    public SignalState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(SignalState currentState) {
        this.currentState = currentState;
    }

    public DIRECTIONS getDirection() {
        return direction;
    }

    public Long getIntersectionId() {
        return intersectionId;
    }

    public SignalState getNextState() {
        return nextState;
    }

    public void setNextState(SignalState nextState) {
        this.nextState = nextState;
    }

    public LightColor getLightColor() {
        return lightColor;
    }

    public void setLightColor(LightColor lightColor) {
        if (lightColor != lightColor){
            this.lightColor = lightColor;
        }

    }

    public void addObserver(TrafficLightObserver observer){
        if (!observers.contains(observer)){
            System.out.println("Adding observer "+observer.toString());
            observers.add(observer);
        }
    }

    public void notifyObservers(){
        for (TrafficLightObserver observer: observers){
            // notify all the observers
            observer.update(intersectionId, direction, lightColor);
        }
    }

    public void makeGreen(Long intersectionId){
        System.out.println("Making the light green for IntersectionId: "+intersectionId);
        this.lightColor = LightColor.GREEN;
        this.currentState = new GREEN_STATE();
    }

    public void makeYellow(Long intersectionId){
        System.out.println("Making the light yellow for IntersectionId: "+intersectionId);
        this.lightColor = LightColor.YELLOW;
        this.currentState = new YELLOW_STATE();
    }
}
