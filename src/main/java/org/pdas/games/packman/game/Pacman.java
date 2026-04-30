package org.pdas.games.packman.game;

import org.pdas.arrays.javaQ.BlockingQExample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.pdas.games.packman.game.GAME_CONSTANTS.*;

public class Pacman extends JPanel implements ActionListener, KeyListener {
    private GameMap map;
    private PacmanEntity pacman;
    private Set<GhostEntity> ghosts;

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
