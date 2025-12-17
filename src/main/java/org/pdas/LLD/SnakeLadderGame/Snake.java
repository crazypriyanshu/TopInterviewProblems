package org.pdas.LLD.SnakeLadderGame;

public class Snake extends BoardEntity{
    public Snake(int start, int end) {
        super(start, end);
        if (start < end){
            throw new IllegalArgumentException("Snake head must be higher than tail");
        }
    }
}
