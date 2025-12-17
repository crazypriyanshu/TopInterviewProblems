package org.pdas.LLD.SnakeLadderGame;

public class Ladder extends BoardEntity{
    public Ladder(int start, int end) {
        super(start, end);
        if (start >= end){
            throw new IllegalArgumentException("Ladder's bottom must be at lower position");
        }
    }
}
