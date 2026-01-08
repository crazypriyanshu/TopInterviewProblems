package org.pdas.designPatterns.learning_1.goodCode.enemy;

public abstract class RealEnemy {
    protected AttackReaction attackReaction;
    public void takeHit(){
        attackReaction.react();
    }
}
