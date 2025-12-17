package org.pdas.LLD.ticTacToe;

import org.pdas.LLD.ticTacToe.Exceptions.InvalidMoveException;
import org.pdas.LLD.ticTacToe.interfaces.GameState;

public class InProgressState implements GameState {
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        synchronized (game){
            // check if correct player is playing the move
            if (game.getCurrentPlayer() != player){
                System.out.println("Its not "+ player.getName() +"'s move");
                throw new InvalidMoveException("Its not "+ player.getName() +"'s move");
            }

            // check if cell is available
            Board board = game.getBoard();
            if (board.getCell(row, col).getSymbol() != Symbol.EMPTY){
                System.out.println("Player: "+player.getName()+ " can't place this symbol, because its already filled with symbol: "+ board.getCell(row, col).getSymbol());
                throw new InvalidMoveException("Player: "+player.getName()+ " can't place this symbol, because its already filled with symbol: "+ board.getCell(row, col).getSymbol());
            }

            // now place the symbol
            game.getBoard().placeSymbol(row, col, player);

            // evaluate the next status of game based on the current move
            if (game.getBoard().isFull()){
                handleDraw(game);
            } else if (game.checkWinner(player)) {
                handleWin(game, player);
            } else {
                game.switchPlayer();
            }

        }
    }

    private void handleDraw(Game game){
        game.setStatus(GameStatus.DRAW);
        game.setState(new DrawState());
        System.out.println("Game is a draw, no player gets any point");
    }

    private void handleWin(Game game, Player player){
        GameStatus status = GameStatus.fromSymbol(player.getSymbol());
        game.setStatus(status);
        game.setWinner(player);
        game.setState(new WinnerState());
        System.out.println("Player : "+ player.getName()+ " with symbol "+ player.getSymbol()+ " wins...");
    }
}
