package org.pdas.designPatterns.learning_1.goodCode.enemy;

public class Slime extends RealEnemy implements Enemy{
    @Override
    public String getDescription() {
        return "A slime is in the club.. Wokoooohu";
    }

    @Override
    public String onAttack() {
        return "You poke the slime! It splits in two!";
    }
}
