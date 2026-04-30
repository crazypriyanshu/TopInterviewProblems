package org.pdas.games.packman.game;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        int rowCount = 21;
        int colCount = 19;
        int titleSize = 32;
        int boardWidth = colCount*titleSize;
        int boardHeight = rowCount*titleSize;

        JFrame frame = new JFrame("Pacman");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Pacman pacmanGame = new Pacman();
        frame.add(pacmanGame);
        frame.pack();
        pacmanGame.requestFocus();
        frame.setVisible(true);
    }
}
