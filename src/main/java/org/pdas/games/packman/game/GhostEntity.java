package org.pdas.games.packman.game;

import java.awt.*;
import java.util.Random;

public class GhostEntity extends MovableBlock {
    private final Random random = new Random();

    GhostEntity(Image image, int x, int y, int width, int height) {
        super(image, x, y, width, height);
    }

    public void pickRandomDirection(){
        DIRECTION[] directions = DIRECTION.values();
        this.direction = directions[random.nextInt(directions.length)];
    }


}
