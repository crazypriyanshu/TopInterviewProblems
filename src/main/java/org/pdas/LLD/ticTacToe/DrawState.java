package org.pdas.LLD.ticTacToe;

import org.pdas.LLD.ticTacToe.Exceptions.InvalidMoveException;
import org.pdas.LLD.ticTacToe.interfaces.GameState;

public class DrawState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        System.out.println(" GAME has reached the "+ game.getState()+ " Hence reseting the game");
        Game.resetGame(game);
        throw new InvalidMoveException("Game is already declared as a DRAW");
    }

    @Override
    public String toString() {
        return "Represents : DrawState{}";
    }
}
