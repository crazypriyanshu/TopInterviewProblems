package org.pdas.LLD.ticTacToe.interfaces;

import org.pdas.LLD.ticTacToe.Board;
import org.pdas.LLD.ticTacToe.Player;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player);
}
