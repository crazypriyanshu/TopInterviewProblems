package org.pdas.LLD.ticTacToe;

import org.pdas.LLD.ticTacToe.Exceptions.InvalidCellException;
import org.pdas.LLD.ticTacToe.interfaces.*;
import org.pdas.LLD.ticTacToe.winningStratergies.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Game extends GameSubject{
    private final String gameId;
    private final Board board;
    private final Player player1;
    private final Player player2;
    private final int size;

    private Player winner;
    private Player currentPlayer;
    private GameStatus status;
    private GameState state;
    private final List<WinningStrategy> winningStrategies;

    // Use of a private constructor to enforce use of static Factory/Builder
    private Game(int size, Player player1, Player player2, List<WinningStrategy> strategies){
        this.gameId = UUID.randomUUID().toString();
        this.size = size;
        this.board = new Board(size);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.state = new InProgressState();
        this.status = GameStatus.IN_PROGRESS;
        this.winningStrategies = strategies;

    }

    /*
    * create method is used to do a fail fast and a cleaner approach to create valid games
    * */
    public static Game create(int size, Player player1, Player player2, List<WinningStrategy> strategies){
        // Preconditions :
        Objects.requireNonNull(player1, "Player 1 can't be null");
        Objects.requireNonNull(player2, "Player 2 can't be null");


        if (player1.getSymbol() == player2.getSymbol()){
            System.out.println("Both player symbols found to be same");
            throw new IllegalArgumentException("Player symbols needs to be different");
        }

        if (size < 3){
            System.out.println("Minimum size to play this game is 3*3, hence size has to be more than 3");
        }

        List<WinningStrategy> actualStrategiesList = (strategies == null || strategies.isEmpty())
                ? List.of(new LockRowWinningStrategy(), new LockColumnWinningStrategy(), new LockDiognalWinningStrategy())
                : strategies;

        return new Game(size, player1, player2, actualStrategiesList);

    }

    public void makeMove(Player player, int row, int col){
        state.handleMove(this, player, row, col);
    }

    public boolean checkWinner(Player player){
        for (WinningStrategy strategy: winningStrategies){
            if (strategy.checkWinner(board, player)){
                return true;
            }
        }
        return false;
    }

    public void switchPlayer(){
        this.currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public static void resetGame(Game game){
        Player player = new Player("SYSTEM", Symbol.EMPTY);
        int size = game.getSize();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                game.getBoard().getCell(row, col).setSymbol(Symbol.EMPTY, player);
            }
        }
        System.out.println("Hard reset done after game status : "+ game.getStatus() + " state of game : "+ game.getState());
        game.setStatus(GameStatus.IN_PROGRESS);
        game.setState(new InProgressState());
    }

    public Board getBoard() {
        return board;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
        if (status != GameStatus.IN_PROGRESS){
            notifyObservers();
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getSize() {
        return size;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public String getGameId() {
        return gameId;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId='" + gameId + '\'' +
                ", board=" + board +
                ", player1=" + player1 +
                ", player2=" + player2 +
                ", size=" + size +
                ", winner=" + winner +
                ", currentPlayer=" + currentPlayer +
                ", status=" + status +
                ", state=" + state +
                ", winningStrategies=" + winningStrategies +
                '}';
    }
}
