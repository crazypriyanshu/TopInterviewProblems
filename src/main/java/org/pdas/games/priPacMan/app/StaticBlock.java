package org.pdas.games.priPacMan.app;

import java.awt.*;

/**
 * Static block can be a food or wall - as they do not move
 * */
public class StaticBlock extends Block{
    protected boolean isFood;

    StaticBlock(Image image, Position position, Dimensions dimension, boolean isFood){
        super(image, position, dimension);
        this.isFood = isFood;
    }
    @Override
    public void draw(Graphics g) {
        if (isFood){
            g.setColor(Color.BLUE);
            g.fillRect(this.position.x, this.position.y, this.dimension.width,this.dimension.height);
        }
    }
}
