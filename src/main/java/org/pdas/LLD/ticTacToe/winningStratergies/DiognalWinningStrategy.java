package org.pdas.LLD.ticTacToe.winningStratergies;

import org.pdas.LLD.ticTacToe.Board;
import org.pdas.LLD.ticTacToe.Player;

public class DiognalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Player player) {
        boolean mainDiagonal = true;
        for (int row = 0; row < board.getSize(); row++) {
            if (board.getCell(row, row).getSymbol() != player.getSymbol()){
                mainDiagonal = false;
                break;
            }
        }
        if (mainDiagonal) return true;
        
        boolean antiDiagonalWin = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCell(i, board.getSize()-i).getSymbol() != player.getSymbol()){
                antiDiagonalWin = false;
                break;
            }
        }
        return antiDiagonalWin;
    }
}
