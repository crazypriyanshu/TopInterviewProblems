package org.pdas.LLD.ticTacToe;

public class Client {
    public static void main(String[] args) {
        TicTacToeManager system = TicTacToeManager.getInstance();
        Player priyanshu = new Player("Priyanshu", Symbol.X);
        Player urvi = new Player("Urvi", Symbol.O);
        Player ricky = new Player("Ricky", Symbol.X);
        Player pari = new Player("PAri", Symbol.O);
//        playDrawGame(system, priyanshu, urvi);
//        playInvalidMove(system, priyanshu, urvi);
        String ticTacToeGame1 = system.createGame(priyanshu, urvi);
//        String ticTacToeGame2 = system.createGame(ricky, pari);
//        String ticTacToeGame3 = system.createGame(priyanshu, pari);
//        String ticTacToeGame4 = system.createGame(urvi, ricky);
        playWinningGame(ticTacToeGame1, system, priyanshu, urvi);
        playWinningGame(ticTacToeGame1, system, urvi, priyanshu);
//        playWinningGame(ticTacToeGame1, system, priyanshu, urvi);
//        playWinningGame(ticTacToeGame1, system, urvi, priyanshu);
//        playWinningGame(ticTacToeGame4, system, urvi, ricky);
//        playWinningGame(ticTacToeGame3, system, priyanshu, pari);
//        playDrawGame(ticTacToeGame3, system, priyanshu, pari);
//        playWinningGame(ticTacToeGame3, system, priyanshu, pari);

    }

    public static void playDrawGame(String gameId, TicTacToeManager system, Player player1, Player player2){
        system.createGame(player1, player2);
        system.makeMove(gameId, player1, 0, 0);
        system.makeMove(gameId, player2, 0, 1);
        system.makeMove(gameId, player1, 1, 0);
        system.makeMove(gameId, player2, 2, 0);
        system.makeMove(gameId, player1, 1, 1);
        system.makeMove(gameId, player2, 1, 2);
        system.makeMove(gameId, player1, 0, 2);
        system.makeMove(gameId, player2, 2, 2);
        system.makeMove(gameId, player1, 2, 1);
    }

    public static void playInvalidMove(String gameId,TicTacToeManager system, Player player1, Player player2){
        system.createGame(player1, player2);
        system.makeMove(gameId, player1, 0, 0);
        system.makeMove(gameId, player2, 0, 0);
    }

    public static void playWinningGame(String gameId,TicTacToeManager system, Player player1, Player player2){
        system.createGame(player1, player2);
        system.makeMove(gameId, player1, 0, 0);
        system.makeMove(gameId, player2, 0, 2);
        system.makeMove(gameId, player1, 1, 0);
        system.makeMove(gameId, player2, 1, 1);
        system.makeMove(gameId, player1, 2, 0);
        system.makeMove(gameId, player2, 1, 2);
    }
}
