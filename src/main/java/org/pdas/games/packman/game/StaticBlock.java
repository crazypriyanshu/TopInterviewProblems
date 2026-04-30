package org.pdas.games.packman.game;

import java.awt.*;

public class StaticBlock extends Block{
    private final boolean isFood;
    StaticBlock(Image image, int x, int y, int width, int height, boolean isFood) {
        super(image, x, y, width, height);
        this.isFood = isFood;
    }

    @Override
    public void draw(Graphics g) {
        if (isFood){
            g.setColor(Color.white);
            g.fillRect(x, y, width, height);
        } else if (image != null) {
            g.drawImage(image, x, y, width, height, null);
        }

    }

    @Override
    public void getBounds() {

    }
}
