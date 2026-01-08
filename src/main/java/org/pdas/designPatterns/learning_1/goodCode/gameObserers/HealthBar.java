package org.pdas.designPatterns.learning_1.goodCode.gameObserers;
// concrete observer
public class HealthBar implements GameObserver{
    @Override
    public void update(int health) {
        System.out.println("UI: Health Bar updated to [ " + health + " / 100 ]");
    }
}
