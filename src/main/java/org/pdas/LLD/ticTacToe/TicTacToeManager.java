package org.pdas.LLD.ticTacToe;

import org.pdas.LLD.ticTacToe.Exceptions.InvalidMoveException;
import org.pdas.LLD.ticTacToe.interfaces.GameState;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// make it a Singleton class
public class TicTacToeManager {
    private static volatile TicTacToeManager instance;
    private Game game;
    private final ScoreBoard scoreBoard;

    // Support multiple games
    private final Map<String, Game> games = new ConcurrentHashMap<>();

    private TicTacToeManager(){
        this.scoreBoard = new ScoreBoard();
    }

    public static TicTacToeManager getInstance(){
        if (instance == null){
            synchronized (TicTacToeManager.class){
                if (instance == null){
                    instance = new TicTacToeManager();
                }
            }

        }
        return instance;
    }

    public String createGame(Player player1, Player player2){
        Game newGame = Game.create(3, player1, player2, null);
        newGame.addObserver(this.scoreBoard);
        games.put(newGame.getGameId(), newGame);
        System.out.printf("[TicTacToe Manager] Game %s created: %s vs %s%n",
                newGame.getGameId(), player1.getName(), player2.getName());
        return newGame.getGameId();
    }

    public String createGame(int size, Player player1, Player player2){
        Game newGame = Game.create(size, player1, player2, null);
        newGame.addObserver(this.scoreBoard);
        games.put(newGame.getGameId() , newGame);
        System.out.printf("[TicTacToe Manager] Game %s created: %s vs %s%n",
                newGame.getGameId(), player1.getName(), player2.getName());
        return newGame.getGameId();
    }

    /*
    *  Idea is to make this a thread safe method
    * */
    public void makeMove(String gameId, Player player, int row, int col){
        Game game = games.get(gameId);
        if (game == null){
            System.out.println("No game in progress...");
            throw new IllegalArgumentException("Game ID "+gameId+" not found");
        }
        synchronized (game){
            try {
                System.out.println(player.getName()+" is playing the move for row and col : "+row+ " "+col);
                game.makeMove(player, row, col);
                game.getBoard().printBoard();
                System.out.println("Game status: "+game.getStatus());
                if (game.getStatus() != GameStatus.IN_PROGRESS){
                    handleGameOver(game);
                }
            } catch (InvalidMoveException e){
                System.out.println("Error in moving to row "+row+ " col : "+col+" :: symbol at this position "+ game.getBoard().getCell(row, col).getSymbol());
                throw new InvalidMoveException(e.getMessage());
            }
        }
    }

    private void handleGameOver(Game game) {
        System.out.println(" Final status of game : "+ game.getStatus());
        if (game.getWinner() != null){
            System.out.println(" Winner identified as "+ game.getWinner().getName());
            scoreBoard.update(game);
        }
        scoreBoard.printScores();
    }

}
