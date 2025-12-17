package org.pdas.LLD.ticTacToe;

import org.pdas.LLD.ticTacToe.interfaces.*;
import org.pdas.LLD.ticTacToe.winningStratergies.*;

import java.util.List;

public class Game extends GameSubject{
    private final Board board;
    private final Player player1;
    private final Player player2;
    private final int size;

    private Player winner;
    private Player currentPlayer;
    private GameStatus status;
    private GameState state;
    private final List<WinningStrategy> winningStrategies;

    public Game(int size, Player player1, Player player2){
        this.size = size;
        this.board = new Board(size);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.state = new InProgressState();
        this.status = GameStatus.IN_PROGRESS;
        this.winningStrategies = List.of(
                new LockRowWinningStrategy(),
                new LockColumnWinningStrategy(),
                new LockDiognalWinningStrategy()
        );

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

    @Override
    public String toString() {
        return "Game{" +
                "board=" + board +
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
