package org.pdas.games.packman.game;

import javax.swing.*;
import java.awt.*;

public class GAME_CONSTANTS {
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
            "XXXX XXXX XXXX XXXX",
            "OOOX X       X XOOO",
            "XXXX X XXrXX X XXXX",
            "O       bpo       O",
            "XXXX X XXXXX X XXXX",
            "OOOX X       X XOOO",
            "XXXX X XXXXX X XXXX",
            "X        X        X",
            "X XX XXX X XXX XX X",
            "X  X     P     X  X",
            "XX X X XXXXX X X XX",
            "X    X   X   X    X",
            "X XXXXXX X XXXXXX X",
            "X                 X",
            "XXXXXXXXXXXXXXXXXXX"
    };

    public static Image wallImage = new ImageIcon(GAME_CONSTANTS.class.getResource("./images/wall.png")).getImage();
    public static Image blueGhost =new ImageIcon(GAME_CONSTANTS.class.getResource("./images/blueGhost.png")).getImage();
    public static Image redGhost = new ImageIcon(GAME_CONSTANTS.class.getResource("./images/redGhost.png")).getImage();
    public static Image pinkGhost = new ImageIcon(GAME_CONSTANTS.class.getResource("./images/pinkGhost.png")).getImage();
    public static Image orangeGhost = new ImageIcon(GAME_CONSTANTS.class.getResource("./images/orangeGhost.png")).getImage();
    public static Image pacemanUpImage= new ImageIcon(GAME_CONSTANTS.class.getResource("./images/pacmanUp.png")).getImage();
    public static Image pacemanDownImage = new ImageIcon(GAME_CONSTANTS.class.getResource("./images/pacmanDown.png")).getImage();
    public static Image pacemanLeftImage = new ImageIcon(GAME_CONSTANTS.class.getResource("./images/pacmanLeft.png")).getImage();
    public static Image pacemanRightImage = new ImageIcon(GAME_CONSTANTS.class.getResource("./images/pacmanRight.png")).getImage();;


}
