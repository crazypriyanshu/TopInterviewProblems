package org.pdas.practice.parkingLot;

import java.util.UUID;

public class Spot {
    private int row;
    private int col;
    private UUID uuid;
    Spot(int row, int col){
        this.uuid = UUID.randomUUID();
        this.row = row;
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "row=" + row +
                ", col=" + col +
                ", uuid=" + uuid +
                '}';
    }
}
