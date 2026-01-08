package org.pdas.designPatterns.learning_1.goodCode.enemy;

public class Orc extends RealEnemy implements Enemy{
    @Override
    public String getDescription() {
        return "An ORC appears with a club!";
    }

    @Override
    public String onAttack() {
        return "You swing and hit the Orc for 10 damage!";
    }

    @Override
    public void takeHit() {
        super.takeHit();
    }
}
