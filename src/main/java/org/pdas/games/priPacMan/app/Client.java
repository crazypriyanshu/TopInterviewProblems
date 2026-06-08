package org.pdas.games.priPacMan.app;



import javax.swing.*;
import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        int rowCount = 21;
        int colCount = 19;
        int titleSize = 32;
        int boardWidth = colCount*titleSize;
        int boardHeight = rowCount*titleSize;

        JFrame frame = new JFrame("Pacman Game");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PacmanGame pacmanGame = new PacmanGame();
        frame.add(pacmanGame);
        frame.pack();
        pacmanGame.requestFocus();
        frame.setVisible(true);
    }
}
