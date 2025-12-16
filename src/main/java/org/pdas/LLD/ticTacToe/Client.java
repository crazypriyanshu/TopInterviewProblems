package org.pdas.LLD.ticTacToe;

public class Client {
    public static void main(String[] args) {
        TicTacToeManager system = TicTacToeManager.getInstance();
        Player priyanshu = new Player("Priyanshu", Symbol.X);
        Player urvi = new Player("Urvi", Symbol.O);
        system.createGame(priyanshu, urvi);
        system.makeMove(priyanshu, 0, 0);
        system.makeMove(urvi, 1, 0);
        system.makeMove(priyanshu, 0, 1);
        system.makeMove(urvi, 1, 1);
        system.makeMove(priyanshu, 0, 2);
    }
}
