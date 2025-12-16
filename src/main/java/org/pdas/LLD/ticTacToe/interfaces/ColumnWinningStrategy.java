package org.pdas.LLD.ticTacToe.interfaces;

import org.pdas.LLD.ticTacToe.Board;
import org.pdas.LLD.ticTacToe.Player;

public class ColumnWinningStrategy implements WinningStrategy{


    @Override
    public boolean checkWinner(Board board, Player player) {
        for (int col = 0; col < board.getSize(); col++) {
            boolean colWin = true;
            for (int row = 0; row < board.getSize(); row++) {
                if (board.getCell(row, col).getSymbol() != player.getSymbol()){
                    colWin = false;
                    break;
                }
                if (colWin) return true;
            }
            return false;
        }
        return false;
    }
}
