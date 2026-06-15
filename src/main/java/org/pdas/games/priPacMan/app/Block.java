package org.pdas.games.priPacMan.app;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Deque;

public abstract class Block {
    protected Position position;
    protected Dimensions dimension;
    protected Image image;
    Deque<Integer> ans = new ArrayDeque<>();
    Block(Image image, Position position, Dimensions dimension){
        this.image = image;
        this.position = position;
        this.dimension = dimension;
    }


    public abstract void draw(Graphics g);
}
