package org.pdas.games.packman.game;

import java.awt.*;

public abstract class Block {
    protected int x, y, width, height;
    Image image;

    Block(Image image, int x, int y, int width, int height ){
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void draw(Graphics g);
    public abstract void getBounds();

    }

