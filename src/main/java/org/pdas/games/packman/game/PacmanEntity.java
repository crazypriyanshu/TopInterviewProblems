package org.pdas.games.packman.game;

import java.awt.*;

import static org.pdas.games.packman.game.GAME_CONSTANTS.*;

public class PacmanEntity extends MovableBlock{
    PacmanEntity(Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
    }



    public void updateVelocity(){
        super.updateVelocity();
        if (direction != null){
            switch (direction){
                case UP -> this.image = pacemanUpImage;
                case DOWN -> this.image = pacemanDownImage;
                case LEFT -> this.image = pacemanLeftImage;
                case RIGHT -> this.image = pacemanRightImage;
            }
        }
    }

    public void move(){
        this.x += this.velocityX;
        this.y += this.velocityY;
    }

}
