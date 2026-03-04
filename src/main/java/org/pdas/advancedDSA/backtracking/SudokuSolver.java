package org.pdas.advancedDSA.backtracking;

public class SudokuSolver {

    private static void solveSudoku(char[][] board){
        if (board == null) return;

    }

    private static boolean solve(char[][] board){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                if (board[i][j] == '.'){
                    for (char c = '1'; c < '9'; c++) {
                        if (isValidSudoku(board, i, j, c)){
                            board[i][j] = c;
                            if (solve(board)){
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }

                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValidSudoku(char[][] sudoku, int row, int col, char numToPlace){
        for (int i = 0; i < 9; i++){
            if (sudoku[row][i] == numToPlace) return false;
            if (sudoku[i][col] == numToPlace) return false;
            int boxRow = 3 * (row/3)+ i/3;
            int boxCol = 3 * (col/3)+ i%3;
            if (sudoku[boxRow][boxCol] == numToPlace) return false;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
