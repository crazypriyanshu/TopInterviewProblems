package org.pdas.LLD.ticTacToe;

import org.pdas.LLD.ticTacToe.Exceptions.InvalidMoveException;
import org.pdas.LLD.ticTacToe.interfaces.GameState;

public class DrawState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        throw new InvalidMoveException("Game is already declared as a DRAW");
    }
}
