package org.pdas.games.packman.game;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class GameMap {
    private final Set<StaticBlock> walls = new HashSet<>();
    private final Set<StaticBlock> foods = new HashSet<>();

    private final Image wallImage;

    public GameMap(Image wallImage){
        this.wallImage = wallImage;
    }

    public void load(String[] titleMap, int tileSize){
        walls.clear();
        foods.clear();

        for (int r = 0; r < titleMap.length; r++) {
            String row = titleMap[r];
            for (int c = 0; c < row.length(); c++) {
                char tileChar = row.charAt(c);
                int x = c*tileSize;
                int y = r*tileSize;

                switch (tileChar){
                    case 'X': walls.add(new StaticBlock(wallImage, x, y, tileSize, tileSize, false));
                    case ' ': foods.add(new StaticBlock(null, x+14, y+14, 4, 4, true));
                }
            }
        }
    }

    public void draw(Graphics g){
        for (StaticBlock wall: walls) wall.draw(g);
        for (StaticBlock food: foods) food.draw(g);
    }

    public Set<StaticBlock> getWalls() {
        return walls;
    }

    public Set<StaticBlock> getFoods() {
        return foods;
    }

    public boolean isEmpty(){
        return foods.isEmpty();
    }
}
