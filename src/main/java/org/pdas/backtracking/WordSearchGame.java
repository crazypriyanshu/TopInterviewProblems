package org.pdas.backtracking;

public class WordSearchGame {
    /*
    * The Problem: Given a 2D grid of characters and a word, find if the word exists in the grid.
    * You can move up, down, left, and right, but you cannot use the same cell twice for a single word.
    * */

    private static boolean exists(char[][] board, String word){
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // start search from every single cell
                if (backtrack(board, word, row, col, 0)){
                    return true;
                }
            }
            
        }
        return false;
    }

    private static boolean backtrack(char[][] board, String word, int row, int col, int index){
        // base case: we found all the characters
        if (index == word.length()) return true;
        // pruning - for out of bounds wrong character or already visisted
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)){
            return false;
        }
        // now select this cell and mark it as visited
        char temp = board[row][col];
        board[row][col] = '#'; // Use a special char to avoid a separate 'used' array,
        boolean found = backtrack(board, word, row+1, col, index+1) ||
                backtrack(board, word, row-1, col, index+1) ||
                backtrack(board, word, row, col+1, index+1) ||
                backtrack(board, word, row, col-1, index+1);
        board[row][col] = temp;
        return found;
    }

    public static void main(String[] args) {
        char[][] wordGame = {{'b', 'a', 't'},
                {'e', 'r', 'o'},
                {'t', 'm', 'n'}};
        long startTime = System.nanoTime();
        System.out.println(exists(wordGame, "bat"));
        System.out.println("Time taken :"+ (System.nanoTime() - startTime)/1000+ " micro secs");

    }


}
