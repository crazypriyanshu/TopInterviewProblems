package org.pdas.designPatterns.learning_1.goodCode.enemy;

public class EnemyFactory {
    public static Enemy createEnemy(EnemyType type){
        return switch (type){
            case ORC -> new Orc();
            case SLIME -> new Slime();
        };
    }
}
