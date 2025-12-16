package org.pdas.LLD.ticTacToe;

import org.pdas.LLD.ticTacToe.Exceptions.InvalidMoveException;
import org.pdas.LLD.ticTacToe.interfaces.GameState;

public class InProgressState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        if (game.getCurrentPlayer() != player){
            throw new InvalidMoveException("Not your move");
        }
        // place the symbol on the location
        game.getBoard().placeSymbol(row, col, player.getSymbol());
        // check for winner
        if (game.checkWinner(player)){
            game.setWinner(player);
            game.setStatus(player.getSymbol() == Symbol.X ? GameStatus.WINNER_X : GameStatus.WINNER_O);
            game.setState(new WinnerState());
        } else if (game.getBoard().isFull()) {
            game.setStatus(GameStatus.DRAW);
            game.setState(new DrawState());
        } else {
            game.switchPlayer();
        }
    }
}
