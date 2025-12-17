package org.pdas.LLD.ticTacToe;

public class Client {
    public static void main(String[] args) {
        TicTacToeManager system = TicTacToeManager.getInstance();
        Player priyanshu = new Player("Priyanshu", Symbol.X);
        Player urvi = new Player("Urvi", Symbol.O);
        playDrawGame(system, priyanshu, urvi);
        playInvalidMove(system, priyanshu, urvi);

    }

    public static void playDrawGame(TicTacToeManager system, Player player1, Player player2){
        system.createGame(player1, player2);
        system.makeMove(player1, 0, 0);
        system.makeMove(player2, 0, 1);
        system.makeMove(player1, 1, 0);
        system.makeMove(player2, 2, 0);
        system.makeMove(player1, 1, 1);
        system.makeMove(player2, 1, 2);
        system.makeMove(player1, 0, 2);
        system.makeMove(player2, 2, 2);
        system.makeMove(player1, 2, 1);
    }

    public static void playInvalidMove(TicTacToeManager system, Player player1, Player player2){
        system.createGame(player1, player2);
        system.makeMove(player1, 0, 0);
        system.makeMove(player2, 0, 0);
    }
}
