package org.pdas.javaConcurreny.designPatternsWithConcurrency.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeSubject {
    // Thread safe DS and optimized for more reads than write
    private final List<Observer> observers = new CopyOnWriteArrayList<>();


    public void register(Observer observer){
        if (observer != null){
            observers.add(observer);
        }
    }

    public void unregister(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(String data){
        for (Observer observer: observers){
            try {
                observer.onDataChange(data);
            } catch (Exception e){
                System.out.println("Error in notifying "+e.getMessage());
                throw new RuntimeException("Invalid data or unable to notify");

            }
        }
    }

}
