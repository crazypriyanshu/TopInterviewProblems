package org.pdas.LLD.bowlMarble;

public class Bowl {
    private final int id;
    private final int capacity;
    private int currentMarbles;

    public Bowl(int id, int capacity){
        this.id = id;
        this.capacity = capacity;
        this.currentMarbles = 0;
    }

    public boolean addMarble(){
        if (currentMarbles+1 >= capacity){
            currentMarbles = 0; // reset
            return true;
        } else {
            currentMarbles++;
            return false;
        }
    }

    public int getCurrentMarbles() {
        return currentMarbles;
    }
}
