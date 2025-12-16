package org.pdas.LLD.ticTacToe.Exceptions;

public class InvalidCellException extends RuntimeException{
    public InvalidCellException(String message){
        super(message);
    }
}
