package org.pdas.LLD.SnakeLadderGame;

import java.util.*;

public class Board {
    private int size;
    Map<Integer, Integer> snakeAndLadder = new HashMap<>();
    private int finalPosition;
    private final Queue<Player> players;

    public Board(int size, List<BoardEntity> entities) {
        this.size = size;
        this.players = new LinkedList<>();
        this.snakeAndLadder = new HashMap<>();
        for (BoardEntity entity: entities){
            snakeAndLadder.put(entity.getStart(), entity.getEnd());
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<Integer, Integer> getSnakeAndLadder() {
        return snakeAndLadder;
    }

    public void setSnakeAndLadder(Map<Integer, Integer> snakeAndLadder) {
        this.snakeAndLadder = snakeAndLadder;
    }

    public int getFinalPosition(int position) {
        return snakeAndLadder.getOrDefault(position, position);
    }

    public void setFinalPosition(int finalPosition) {
        this.finalPosition = finalPosition;
    }

    @Override
    public String toString() {
        return "Board{" +
                "size=" + size +
                ", snakeAndLadder=" + snakeAndLadder +
                ", finalPosition=" + finalPosition +
                '}';
    }
}
