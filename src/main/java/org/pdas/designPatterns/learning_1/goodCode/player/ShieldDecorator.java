package org.pdas.designPatterns.learning_1.goodCode.player;

public class ShieldDecorator extends PlayerDecorator{
    public ShieldDecorator(Player player) {
        super(player);
    }

    @Override
    public String getPlayerDescription() {
        return super.getPlayerDescription()+" with a Sturdy Shield";
    }
}
