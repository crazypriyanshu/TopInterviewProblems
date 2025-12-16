package org.pdas.LLD.ticTacToe;

import org.pdas.LLD.ticTacToe.Exceptions.InvalidMoveException;

// make it a Singleton class
public class TicTacToeManager {
    private static volatile TicTacToeManager instance;
    private Game game;
    private final ScoreBoard scoreBoard;

    private TicTacToeManager(){
        this.scoreBoard = new ScoreBoard();
    }

    public static synchronized TicTacToeManager getInstance(){
        if (instance == null){
            instance = new TicTacToeManager();
        }
        return instance;
    }

    public void createGame(Player player1, Player player2){
        this.game = new Game(3, player1, player2);
        this.game.addObserver(this.scoreBoard);
        System.out.printf("Game started between %s (X) and %s (O).%n", player1.getName(), player2.getName());
    }

    public void createGame(int size, Player player1, Player player2){
        this.game = new Game(size, player1, player2);
        this.game.addObserver(this.scoreBoard);
    }

    public void makeMove(Player player, int row, int col){
        if (game == null){
            System.out.println("No game in progress...");
            return;
        }
        try {
            System.out.println(player.getName()+" is playing the move for row and col : "+row+ " "+col);
            game.makeMove(player, row, col);
            game.getBoard().printBoard();
            System.out.println("Game status: "+game.getStatus());
            if (game.getWinner() != null){
                System.out.println(" Winner is : "+ game.getWinner().getName());
                scoreBoard.printScores();
            }
        } catch (InvalidMoveException e){
            System.out.println("Error");
        }
    }

}
