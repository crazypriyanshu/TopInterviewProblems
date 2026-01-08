package org.pdas.designPatterns.learning_1.goodCode.enemy;

public class SplitReaction implements AttackReaction {
    @Override
    public void react() {
        System.out.println("Enemy -It splits in two!");
    }
}
