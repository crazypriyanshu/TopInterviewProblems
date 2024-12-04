package org.pdas.matrix;

import java.util.Arrays;

public class NQueenProblem {
    public static boolean isSafe(int row, int col, char[][] board){
        // horizontal
        for (int i =0; i < board.length; i++){
            if (board[row][i] == 'Q'){
                return false;
            }
        }

        // vertical
        for (int i=0; i< board.length; i++) {
            if (board[i][col] == 'Q'){
                return false;
            }
        }

        // upper Left
        int r = row;
        for (int c = col; c >=0 && r >= 0; c--,r--){
            if (board[r][c] == 'Q'){
                return false;
            }
        }

        // upper right
        r = row;
        for (int c = col; c < board.length && r >= 0; c++, r--){
            if (board[r][c] == 'Q'){
                return false;
            }
        }

        // lower left
        r = row;
        for (int c = col; c >= 0 && r < board.length; c--, r++){
            if (board[r][c] == 'Q'){
                return false;
            }
        }

        // lower right
        for (int c = col; c < board.length && r < board.length; r++, c++){
            if (board[r][c] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'Q', '.', '.'},{'.','.', '.'},{'.','.', '.'}};

        System.out.println(isSafe(1, 2, board));

    }
}
