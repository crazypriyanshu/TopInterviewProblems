package org.pdas.designPatterns.learning_1.goodCode.player;

public class FireSwordDecorator extends PlayerDecorator{
    public FireSwordDecorator(Player player) {
        super(player);
    }

    @Override
    public String getPlayerDescription() {
        return super.getPlayerDescription()+" with a Flaming Sword";
    }
}
