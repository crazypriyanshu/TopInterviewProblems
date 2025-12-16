package org.pdas.LLD.ticTacToe.Exceptions;

public class InvalidMoveException extends RuntimeException{
    public InvalidMoveException(String message){
        super(message);
    }
}
