package org.pdas.LLD.ticTacToe.interfaces;

import org.pdas.LLD.ticTacToe.Game;
import org.pdas.LLD.ticTacToe.Player;

public interface GameState {
    void handleMove(Game game, Player player, int row, int col);
}
