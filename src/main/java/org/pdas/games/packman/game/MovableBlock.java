package org.pdas.games.packman.game;

import java.awt.*;

import static org.pdas.games.packman.game.GAME_CONSTANTS.tileSize;

public class MovableBlock extends Block{
    protected int velocityX, velocityY;
    protected DIRECTION direction;

    MovableBlock(Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
    }

    public void updatePosition(){
        updateVelocity();
        this.x += velocityX;
        this.y += velocityY;
    }

    public void updateVelocity(){
        if (this.direction == DIRECTION.UP){
                this.velocityX = 0;
                this.velocityY = -tileSize/4;
            }

            if (this.direction == DIRECTION.DOWN){
                this.velocityX = 0;
                this.velocityY = tileSize/4;
            }

            if (this.direction == DIRECTION.LEFT){
                this.velocityX = -tileSize/4;
                this.velocityY = 0;
            }

            if (this.direction == DIRECTION.RIGHT){
                this.velocityX = tileSize/4;
                this.velocityY = 0;
            }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, x, y, width, height, null);
    }

    @Override
    public void getBounds() {

    }

    public void move(){

    }
}
