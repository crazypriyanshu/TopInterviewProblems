package org.pdas.designPatterns.learning_1.goodCode;

import org.pdas.designPatterns.learning_1.goodCode.commands.AttackCommand;
import org.pdas.designPatterns.learning_1.goodCode.commands.Command;
import org.pdas.designPatterns.learning_1.goodCode.commands.GameInputInvoker;
import org.pdas.designPatterns.learning_1.goodCode.enemy.Enemy;
import org.pdas.designPatterns.learning_1.goodCode.enemy.EnemyFactory;
import org.pdas.designPatterns.learning_1.goodCode.enemy.EnemyType;
import org.pdas.designPatterns.learning_1.goodCode.gameObserers.GameObserver;
import org.pdas.designPatterns.learning_1.goodCode.gameObserers.HealthBar;
import org.pdas.designPatterns.learning_1.goodCode.gameObserers.ObservablePlayer;
import org.pdas.designPatterns.learning_1.goodCode.gameObserers.SoundEngine;
import org.pdas.designPatterns.learning_1.goodCode.player.FireSwordDecorator;
import org.pdas.designPatterns.learning_1.goodCode.player.Player;
import org.pdas.designPatterns.learning_1.goodCode.player.ShieldDecorator;
import org.pdas.designPatterns.learning_1.goodCode.player.SimplePlayer;

public class AdventureGameUpgraded {
    public static void playWithFireSword(EnemyType enemyType){
        Enemy monster = EnemyFactory.createEnemy(enemyType);
        Player me = new FireSwordDecorator(new SimplePlayer());
        System.out.println("You are: "+ me.getPlayerDescription());
        System.out.println("You attack type: "+enemyType);
        System.out.println(monster.onAttack());
        System.out.println();
        System.out.println();
    }

    public static void playWithSheildDecorator(EnemyType enemyType){
        Enemy monster = EnemyFactory.createEnemy(enemyType);
        Player me = new ShieldDecorator(new SimplePlayer());
        System.out.println("You are: "+ me.getPlayerDescription());
        System.out.println("You attack type: "+enemyType);
        System.out.println(monster.onAttack());

        System.out.println();
    }

    public static void main(String[] args) {
        ObservablePlayer player = new ObservablePlayer();
        player.addObserver(new HealthBar());
        player.addObserver(new SoundEngine());

        GameInputInvoker inputInvoker = new GameInputInvoker();
        Command hitByOrc = new AttackCommand(player, 20);
        inputInvoker.executeCommand(hitByOrc);

        Command hitByBoss = new AttackCommand(player, 50);
        inputInvoker.executeCommand(hitByBoss);

        inputInvoker.unDoLastAction();

        Player armouredPlayer = new FireSwordDecorator(new SimplePlayer());
        System.out.println("Current Hero is: "+armouredPlayer.getPlayerDescription());

        Enemy monster = EnemyFactory.createEnemy(EnemyType.ORC);
        player.takeDamage(85);

//        playWithFireSword(EnemyType.ORC);
//        playWithFireSword(EnemyType.SLIME);
//
//        playWithSheildDecorator(EnemyType.ORC);
//        playWithSheildDecorator(EnemyType.SLIME);
    }
}
