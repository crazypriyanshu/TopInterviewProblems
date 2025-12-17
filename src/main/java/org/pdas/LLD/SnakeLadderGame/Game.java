package org.pdas.LLD.SnakeLadderGame;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private Dice dice;
    private Board board;
    private GameStatus gameStatus;
    private Queue<Player> playerQueue;
    private Player winner;

    private Game(Board board, List<Player> players, Dice dice){
        this.board = board;
        this.dice = dice;
        this.playerQueue = new LinkedList<>(players);
        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public void takeTurn(Player player){
        int roll = dice.roll();
        System.out.println(player.getName()+ " rolled dice and got : "+roll);
        int currPosition = player.getPosition();
        int nextPosition = currPosition+roll;

        if (nextPosition > board.getSize()){
            System.out.println("Oops !"+player.getName()+" you are out of limit and need to land exactly "+ board.getSize());
        }

        if (nextPosition == board.getSize()){
            player.setPosition(nextPosition);
            this.winner = player;
            this.gameStatus = GameStatus.FINISHED;
            System.out.println("Horray ! Player : "+player.getName()+ " won!, current position "+ player.getPosition());
            return;
        }

        int finalPosition = board.getFinalPosition(nextPosition);
        if (finalPosition > nextPosition){
            System.out.println("Woow! Found a ladder and player : "+player.getName()+ " moved from "+nextPosition+" to final Position "+finalPosition);
        } else if (finalPosition < nextPosition) {
            System.out.println("Oh No! Found a snake and player:  "+ player.getName()+ " moved from "+ nextPosition+ " to final position "+finalPosition);
        } else {
            System.out.println("Player : "+ player.getName()+ " moved from "+ currPosition+ " to finalPosition: "+ finalPosition);
        }
        if (roll == 6){
            System.out.println("Player got a 6, deserves another chance");
            takeTurn(player);
        }
    }


    public Game(Builder builder){
        this.board = builder.board;
        this.playerQueue = new LinkedList<>(builder.players);
        this.dice = builder.dice;
        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public void play(){
        if (playerQueue.size() <= 2){
            System.out.println("Can't start a game , at least 2 players are required");
        }
        this.gameStatus = GameStatus.RUNNING;
        System.out.println("Game started");
        while (gameStatus == GameStatus.RUNNING){
            Player currentPlayer = playerQueue.poll();
            takeTurn(currentPlayer);

            // If the game is not finished and the player didn't roll a 6, add them back to the queue
            if (gameStatus == GameStatus.RUNNING){
                playerQueue.add(currentPlayer);
            }

            System.out.println("--- Game finished ---");
            if (winner != null){
                System.out.println(" Winner of teh game is : "+ winner.getName());
            }
        }
    }

    public static class Builder {
        private Board board;
        private List<Player> players;
        private Dice dice;

        public Builder setBoard(int boardSize, List<BoardEntity> boardEntities){
            this.board = new Board(boardSize, boardEntities);
            return this;
        }

        public Builder setPlayers(List<Player> players){
            if (players == null || players.size() < 2){
                throw new IllegalArgumentException("players cant be null or should be at least 2");
            }
            this.players = new ArrayList<>(players);
            return this;
        }

        public Builder setDice(Dice dice){
            this.dice = dice;
            return this;
        }

        public Game build(){
            if (board == null || players == null || dice == null){
                throw new IllegalArgumentException("Board, player or dice must be set");
            }
            return new Game(this);
        }
    }

}
