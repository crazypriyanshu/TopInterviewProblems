package org.pdas.games.priPacMan.app;


import java.awt.*;

import static org.pdas.games.priPacMan.app.GameConstants.tileSize;

/**
 * Movable blocks can move - they should have a velocity and a method to keep updating its position on the board
 * */
public class MovableBlocks extends Block {
    protected int velocityX;
    protected int velocityY;
    protected DIRECTIONS direction;
    protected int startX;
    protected int startY;


    MovableBlocks(Image image, Position position, Dimensions dimension) {
        super(image, position, dimension);
        this.startX = position.getX();
        this.startY = position.getY();

    }

    public void updatePosition(){
        updateVelocity();
        this.position.x += velocityX;
        this.position.y += velocityY;

    }

    protected void updateVelocity(){
        switch (this.direction){
            case UP -> {
                this.velocityX = 0;
                this.velocityY = -tileSize/4;
            }
            case DOWN -> {
                this.velocityX = 0;
                this.velocityY = tileSize/4;
            }

            case LEFT -> {
                this.velocityX = -tileSize/4;
                this.velocityY = 0;
            }

            case RIGHT -> {
                this.velocityX = tileSize/4;
                this.velocityY = 0;
            }

        }
    }

    public void reset(){
        this.position.x = startX;
        this.position.y = startY;
    }

    @Override
    public void draw(Graphics g) {

    }
}
