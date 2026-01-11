package org.pdas.backtracking;

import java.util.*;

public class NQueenProblem {
    // Place N queens on an N*N chessboard so that no two queens can attack each other.
    private static Set<Integer> colSet = new HashSet<>();
    private static Set<Integer> diagonalSet = new HashSet<>();
    private static Set<Integer> antiDiagonalSet = new HashSet<>();
    private static List<List<String>> res = new ArrayList<>();

    private static List<List<String>> solveNQueen(int n){
        char[][] board = new char[n][n];
        for (char[] row: board) {
            Arrays.fill(row, '.');
        }
        backtrack(board, n, 0);
        return res;
    }

    private static void backtrack(char[][] board, int n, int row){
        // base case -- end of the row, means we are just going row by row
        if (row == n){
            res.add(constructBoard(board));
            return;
        }
        for (int col = 0; col < n; col++){
            // pruning: is this cell under attack??
            if (colSet.contains(col) || diagonalSet.contains(col+row) || antiDiagonalSet.contains(row-col)){
                continue;
            }
            // the choice: placing the queen
            colSet.add(col);
            diagonalSet.add(col+row);
            antiDiagonalSet.add(row-col);
            board[row][col] = 'Q';

            // move to next row
            backtrack(board, n, row+1);
            colSet.remove(col);
            diagonalSet.remove(col+row);
            antiDiagonalSet.remove(row - col);
            board[row][col] = '.';
        }

    }

    private static List<String> constructBoard(char[][] board){
        List<String> path = new ArrayList<>();
        for (char[] row: board){
            path.add(new String(row));

        }
        return path;
    }

    public static void main(String[] args) {
        int n = 4;
        solveNQueen(n).stream().forEach(System.out::println);
    }
}
