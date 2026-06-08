package org.pdas.games.priPacMan.app;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static org.pdas.games.priPacMan.app.GameConstants.*;

public class PacmanGame extends JPanel implements ActionListener, KeyListener {

    private Image wallImage;
    private Image blueGhostImage;
    private Image orangeGhostImage;
    private Image pinkGhostImage;
    private Image redGhostImage;

    private Image pacmanUpImage;
    private Image pacmanDownImage;
    private Image pacmanLeftImage;
    private Image pacmanRightImage;

    private Set<MovableBlocks> ghosts;
    private Set<StaticBlock> walls;
    private Set<StaticBlock> foods;
    private MovableBlocks pacman;
    private Timer gameLoop;
    Random random = new Random();
    private int score;
    private int lives = 3;
    boolean isGameOver;
    private DIRECTIONS[] directions = DIRECTIONS.values();

    // constructor
    public PacmanGame() throws IOException {

        try {

            System.out.println("Step1: Initializing game");
            setPreferredSize(new Dimension(boardWidth, boardHeight));
            setBackground(Color.BLACK);
            addKeyListener(this);
            setFocusable(true);

            System.out.println("Step2: Loading images of game");
            // load images
            wallImage = ImageIO.read(getClass().getResource("/images/wall.png"));


            orangeGhostImage = ImageIO.read(getClass().getResource("/images/orangeGhost.png"));
            blueGhostImage = ImageIO.read(getClass().getResource("/images/blueGhost.png"));
            redGhostImage = ImageIO.read(getClass().getResource("/images/redGhost.png"));
            pinkGhostImage = ImageIO.read(getClass().getResource("/images/pinkGhost.png"));

            pacmanUpImage = ImageIO.read(getClass().getResource("/images/pacmanUp.png"));
            pacmanDownImage = ImageIO.read(getClass().getResource("/images/pacmanDown.png"));
            pacmanLeftImage = ImageIO.read(getClass().getResource("/images/pacmanLeft.png"));
            pacmanRightImage = ImageIO.read(getClass().getResource("/images/pacmanRight.png"));

            wallImage = ImageIO.read(getClass().getResource("/images/wall.png"));
            loadMap();
            for (MovableBlocks ghost: ghosts){
                ghost.direction = directions[random.nextInt(directions.length)];
                //System.out.println("Updated directions of ghost: "+ghost.direction.name()+ " "+ghost.image.getClass());
                ghost.updatePosition();
            }
            gameLoop = new Timer(50, this);
            gameLoop.start();
        } catch (IOException |IllegalArgumentException e) {
            System.err.println("Fatal Error: could not load game "+e.getMessage());
            e.printStackTrace();
            System.exit(10);
        }
    }

    public void loadMap(){
        walls = new HashSet<>();
        foods = new HashSet<>();
        ghosts = new HashSet<>();

        for (int row = 0; row < GameConstants.rowCount; row++) {
            for (int col = 0; col < GameConstants.columnCount; col++) {
                String rowData = GameConstants.tileMap[row];
                char titleMapChar = rowData.charAt(col);
                int x = col * tileSize;
                int y = row * tileSize;

                switch (titleMapChar){
                    case 'X' -> {
                        // wall
                        StaticBlock wall = new StaticBlock(wallImage, new Position(x, y), new Dimensions(tileSize, tileSize), false);
                        walls.add(wall);
                    }
                    case 'b' -> {
                        // blue Ghost
                        MovableBlocks blueGhost = new MovableBlocks(blueGhostImage, new Position(x, y), new Dimensions(tileSize, tileSize));
                        ghosts.add(blueGhost);
                    }

                    case 'o' -> {
                        // orange Ghost
                        MovableBlocks orangeGhost = new MovableBlocks(orangeGhostImage, new Position(x, y), new Dimensions(tileSize, tileSize));
                        ghosts.add(orangeGhost);
                    }

                    case 'p' -> {
                        // pink Ghost
                        MovableBlocks pinkGhost = new MovableBlocks(pinkGhostImage, new Position(x, y), new Dimensions(tileSize, tileSize));
                        ghosts.add(pinkGhost);
                    }

                    case 'r' -> {
                        // red Ghost
                        MovableBlocks redGhost = new MovableBlocks(redGhostImage, new Position(x, y), new Dimensions(tileSize, tileSize));
                        ghosts.add(redGhost);
                    }

                    case 'P' -> {
                        // Pacman
                        pacman = new MovableBlocks(pacmanRightImage, new Position(x, y), new Dimensions(tileSize, tileSize));

                    }
                    case ' ' -> {
                        StaticBlock food = new StaticBlock(null, new Position(x+14, y+14), new Dimensions(4, 4), true);
                        foods.add(food);
                    }


                }

            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);

    }

    public void draw(Graphics g){
        g.drawImage(pacman.image, pacman.position.x, pacman.position.y, pacman.dimension.width, pacman.dimension.height, null);
        for (MovableBlocks ghost: ghosts){
            g.drawImage(ghost.image, ghost.position.x, ghost.position.y, ghost.dimension.width, ghost.dimension.height, null);
        }

        for (StaticBlock wall: walls){
            g.drawImage(wall.image, wall.position.x, wall.position.y, wall.dimension.width, wall.dimension.height, null);
        }
        g.setColor(Color.WHITE);
        for (StaticBlock food: foods){
            g.fillRect(food.position.x, food.position.y, food.dimension.width, food.dimension.height);
        }

        g.setFont(new Font("Arial", Font.BOLD, 18));
        if (isGameOver){
            g.drawString("Game over: "+String.valueOf(score), tileSize/2, tileSize/2);
        } else {
            g.drawString("x" + String.valueOf(lives)+ " Score: "+ String.valueOf(score), tileSize/2, tileSize/2);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
        if (isGameOver){
            gameLoop.stop();
        }

    }

    private boolean isCollision(Block a, Block b){
        // Check X-axis overlap: Is A's left side to the left of B's right side AND A's right side to the right of B's left side?
        boolean overlapX = (a.position.x < b.position.x + b.dimension.width) &&
                (a.position.x + a.dimension.width > b.position.x);

        // Check Y-axis overlap: Is A's top side above B's bottom side AND A's bottom side below B's top side?
        boolean overlapY = (a.position.y < b.position.y + b.dimension.height) &&
                (a.position.y + a.dimension.height > b.position.y);

        // A collision only happens if they overlap on BOTH axes
        return overlapX && overlapY;
    }

    public void resetPositions(){
        pacman.reset();
        pacman.velocityX = 0;
        pacman.velocityY = 0;
        for (MovableBlocks ghost: ghosts){
            ghost.reset();
            DIRECTIONS direction = directions[random.nextInt(directions.length)];
            ghost.direction = direction;
            ghost.updateVelocity();
        }
    }

    /**
     * Logic for movement
     * */
    public void move(){

        pacman.position.x += pacman.velocityX;
        pacman.position.y += pacman.velocityY;

        for (StaticBlock wall: walls){
            if (isCollision(wall, pacman)){
                pacman.position.x -= pacman.velocityX;
                pacman.position.y -= pacman.velocityY;
                break;
            }
        }

        // check ghost collision
        for (MovableBlocks ghost: ghosts){
            if (isCollision(ghost, pacman)){
                lives -= 1;
                if (lives == 0){
                    isGameOver = true;
                }
                resetPositions();
            }

            if (ghost.position.y == tileSize * 9 && ghost.direction != DIRECTIONS.UP && ghost.direction != DIRECTIONS.DOWN){
                ghost.direction = DIRECTIONS.UP;
            }

            ghost.position.x += ghost.velocityX;
            ghost.position.y += ghost.velocityY;

            for (StaticBlock wall: walls){
                if (isCollision(wall, ghost) || ghost.position.x <= 0 || (ghost.position.x + ghost.dimension.width) >= boardWidth){
                    ghost.position.x -= ghost.velocityX;
                    ghost.position.y -= ghost.velocityY;
                    DIRECTIONS newDirection = directions[random.nextInt(directions.length)];
                    ghost.direction = newDirection;
                    ghost.updateVelocity();
                }
            }
        }

        StaticBlock foodEaten = null;
        for (StaticBlock food: foods){
            if (isCollision(food, pacman)){
                foodEaten = food;
                score += 10;
            }
        }
        foods.remove(foodEaten);

        if (foods.isEmpty()){
            loadMap();
            resetPositions();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (isGameOver){
            loadMap();
            resetPositions();
            lives = 3;
            score = 0;
            isGameOver =false;
            gameLoop.start();

        }

        if (e.getKeyCode() == KeyEvent.VK_UP){
            pacman.direction = DIRECTIONS.UP;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            pacman.direction = DIRECTIONS.DOWN;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            pacman.direction = DIRECTIONS.RIGHT;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            pacman.direction = DIRECTIONS.LEFT;
        }
        pacman.updateVelocity();

        if(pacman.direction == DIRECTIONS.UP){
            pacman.image = pacmanUpImage;
        } else if (pacman.direction == DIRECTIONS.DOWN) {
            pacman.image = pacmanDownImage;
        } else if(pacman.direction == DIRECTIONS.LEFT){
            pacman.image = pacmanLeftImage;
        } else {
            pacman.image = pacmanRightImage;
        }

    }
}
