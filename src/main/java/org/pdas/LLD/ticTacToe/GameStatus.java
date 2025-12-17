package org.pdas.LLD.ticTacToe;

public enum GameStatus {
    IN_PROGRESS,
    WINNER_X,
    WINNER_O,
    DRAW,
    SUSPENDED;

    public static GameStatus fromSymbol(Symbol symbol){
        return (symbol == Symbol.X) ? WINNER_X: WINNER_O;
    }


}
