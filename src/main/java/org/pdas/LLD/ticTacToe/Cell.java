package org.pdas.LLD.ticTacToe;

public class Cell {
    private Symbol symbol;
    private Player player;

    public Cell(){
        this.player = null;
        this.symbol = Symbol.EMPTY;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol, Player player) {
        this.symbol = symbol;
        this.player = player;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "symbol=" + symbol +
                '}';
    }
}
