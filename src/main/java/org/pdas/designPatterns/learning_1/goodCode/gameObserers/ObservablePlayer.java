package org.pdas.designPatterns.learning_1.goodCode.gameObserers;

import org.pdas.designPatterns.learning_1.goodCode.player.Player;

import java.util.ArrayList;
import java.util.List;
// this class becomes the subject
public class ObservablePlayer implements Player {
    private List<GameObserver> observers = new ArrayList<>();
    private int health = 100;

    public void addObserver(GameObserver observer){
        this.observers.add(observer);
    }

    public void takeDamage(int damage){
        this.health -= damage;
        System.out.println("\n--- Player took " + damage + " damage! ---");
        // notify every observer
        for (GameObserver observer: observers){
            observer.update(this.health);
        }
    }
    @Override
    public String getPlayerDescription() {
        return "The hero";
    }
}
