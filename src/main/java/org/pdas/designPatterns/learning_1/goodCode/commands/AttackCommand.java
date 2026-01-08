package org.pdas.designPatterns.learning_1.goodCode.commands;

import org.pdas.designPatterns.learning_1.goodCode.gameObserers.ObservablePlayer;

public class AttackCommand implements Command{
    private ObservablePlayer player;
    private int damageDealt;

    public AttackCommand(ObservablePlayer player, int damageDealt){
        this.player = player;
        this.damageDealt = damageDealt;
    }
    @Override
    public void execute() {
        player.takeDamage(damageDealt);

    }

    @Override
    public void unDo() {
        System.out.println("--- UNDO: Player magically heals " + damageDealt + " health! ---");
        player.takeDamage(-damageDealt); // Healing is just negative damage!

    }
}
