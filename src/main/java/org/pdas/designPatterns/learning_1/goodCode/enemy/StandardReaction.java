package org.pdas.designPatterns.learning_1.goodCode.enemy;

public class StandardReaction implements AttackReaction {
    @Override
    public void react() {
        System.out.println("The enemy takes 10 damage and grunts!");
    }
}
