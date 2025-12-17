package org.pdas.LLD.ticTacToe.winningStratergies;

import org.pdas.LLD.ticTacToe.Board;
import org.pdas.LLD.ticTacToe.Player;
import org.pdas.LLD.ticTacToe.Symbol;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockRowWinningStrategy implements WinningStrategy{
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    @Override
    public boolean checkWinner(Board board, Player player) {
        lock.readLock().lock(); // ensure no one is writing
        try {
            int size = board.getSize();
            for (int row = 0; row < size; row++) {
                if (checkSpecificRow(board, row, player.getSymbol())){
                    return true;
                }
            }
            return false;
        } finally {
            lock.readLock().unlock();
        }
    }

    private boolean checkSpecificRow(Board board, int row, Symbol symbol){
        for (int col = 0; col < board.getSize(); col++) {
            if (board.getCell(row, col).getSymbol() != symbol){
                return false;
            }
        }
        return true;
    }
}
