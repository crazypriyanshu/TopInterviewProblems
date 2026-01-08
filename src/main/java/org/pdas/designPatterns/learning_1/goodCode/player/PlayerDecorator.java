package org.pdas.designPatterns.learning_1.goodCode.player;

public abstract class PlayerDecorator implements Player {
    protected Player decoratedPlayer;

    public PlayerDecorator(Player player){
        this.decoratedPlayer = player;
    }
    public String getPlayerDescription() {
        return decoratedPlayer.getPlayerDescription();
    }

}
