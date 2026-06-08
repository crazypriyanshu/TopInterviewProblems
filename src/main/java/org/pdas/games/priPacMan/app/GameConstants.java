package org.pdas.games.priPacMan.app;

import javax.swing.*;
import java.awt.*;

public class GameConstants {
    public static int rowCount = 21;
    public static int columnCount = 19;
    public static int tileSize = 32;
    public static int boardWidth = columnCount * tileSize;
    public static int boardHeight = rowCount * tileSize;
    //X = wall, O = skip, P = pac man, ' ' = food
    //Ghosts: b = blue, o = orange, p = pink, r = red
    public static String[] tileMap = {
            "XXXXXXXXXXXXXXXXXXX",
            "X        X        X",
            "X XX XXX X XXX XX X",
            "X                 X",
            "X XX X XXXXX X XX X",
            "X    X       X    X",
            "XXXX XXXX XXXX XX X",
            "OOOX X       X XOOO",
            "XXXX X XXrXX X XXXX",
            "O       bpo       O",
            "XXXX X XXXXX X XX X",
            "OOOX X       X XOOO",
            "XXXX X XXXXX X XXXX",
            "X        X        X",
            "X XX XXX X XXX XX X",
            "X  X     P     X  X",
            "XX X X XXXXX X X XX",
            "X    X   X   X    X",
            "X XX XXX X XXX XX X",
            "X                 X",
            "XXXXXXXXXXXXXXXXXXX"
    };
}
