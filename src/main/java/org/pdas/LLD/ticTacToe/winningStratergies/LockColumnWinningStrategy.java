package org.pdas.LLD.ticTacToe.winningStratergies;

import org.pdas.LLD.ticTacToe.Board;
import org.pdas.LLD.ticTacToe.Player;
import org.pdas.LLD.ticTacToe.Symbol;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockColumnWinningStrategy implements WinningStrategy{
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    @Override
    public boolean checkWinner(Board board, Player player) {

        lock.readLock().lock(); // ensure no one is writing
        try {
            int size = board.getSize();
            for (int col = 0; col < size; col++) {
                if (checkSpecificCol(board, col, player.getSymbol())){
                    return true;
                }
            }
            return false;
        } finally {
            lock.readLock().unlock();
        }
    }

    private boolean checkSpecificCol(Board board, int col, Symbol symbol){
        for (int row = 0; row < board.getSize(); row++) {
            if (board.getCell(row, col).getSymbol() != symbol){
                return false;
            }
        }
        return true;
    }
}
