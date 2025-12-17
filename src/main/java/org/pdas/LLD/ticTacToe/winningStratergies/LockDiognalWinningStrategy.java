package org.pdas.LLD.ticTacToe.winningStratergies;

import org.pdas.LLD.ticTacToe.Board;
import org.pdas.LLD.ticTacToe.Player;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockDiognalWinningStrategy implements WinningStrategy{
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    @Override
    public boolean checkWinner(Board board, Player player) {
        lock.readLock().lock();
        try {
            boolean mainDiagonal = false;
            int size = board.getSize();
            for (int row = 0; row < size; row++) {
                if (board.getCell(row, row).getSymbol() != player.getSymbol()){
                    mainDiagonal = false;
                    break;
                }
            }
            if (mainDiagonal) return true;

            boolean antiDiagonal = true;
            for (int i = 0; i < size; i++) {
                if (board.getCell(i,size-1-i).getSymbol() != player.getSymbol()){
                    antiDiagonal = false;
                    break;
                }
            }
            return antiDiagonal;
        } finally {
            lock.readLock().unlock();
        }
    }
}
