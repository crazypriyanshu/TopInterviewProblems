package org.pdas.LLD.ticTacToe;

import org.pdas.LLD.ticTacToe.Exceptions.InvalidCellException;
import org.pdas.LLD.ticTacToe.Exceptions.InvalidMoveException;

import java.util.Arrays;

public class Board {
    private int size = 3;
    private Cell[][] board;
    private int moves_count;

    public Board(int size){
        this.size = size;
        this.board = new Cell[size][size];
        this.moves_count = 0;
        initializeBoard();
    }

    private void initializeBoard(){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = new Cell();
            }
            
        }
    }

    public boolean isFull(){
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (getCell(row, col).getSymbol() != Symbol.X || getCell(row, col).getSymbol() != Symbol.O){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean placeSymbol(int row, int col, Player player){
        // check the values
        if (row < 0 || row >= size || col < 0 || col >= size){
            throw  new InvalidMoveException("Moves are going beyond boundaries");
        }

        // if you already have a symbol there
        if (board[row][col].getSymbol() != Symbol.EMPTY){
            System.out.println("This is not a valid move, as this cell is already filled with "+board[row][col].getSymbol());
            throw new InvalidMoveException("Symbol is already present in this cell");
        }

        board[row][col].setSymbol(player.getSymbol(), player);
        moves_count++;
        return true;
    }

    public Cell getCell(int row, int col){
        if (row < 0 || row >= size || col < 0 || col >= size){
            throw new InvalidCellException("Get cell failing because of values are out of range");
        }
        return board[row][col];
    }

    public void printBoard(){
        System.out.println("------------");
        for (int row = 0; row < size; row++) {
            System.out.print("| ");
            for (int col = 0; col < size; col++) {
                Symbol symbol = board[row][col].getSymbol();
                System.out.print(symbol.getChar()+" | ");
            }
            System.out.println("");

        }
        System.out.println("------------");
    }

    public int getMoves_count() {
        return moves_count;
    }

    public void setMoves_count(int moves_count) {
        this.moves_count = moves_count;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void setBoard(Cell[][] board) {
        this.board = board;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Board{" +
                "size=" + size +
                ", board=" + Arrays.toString(board) +
                ", moves_count=" + moves_count +
                '}';
    }
}
