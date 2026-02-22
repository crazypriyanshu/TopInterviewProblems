package org.pdas.recursion;

import java.util.HashMap;
import java.util.Map;

public class WordCheck {
    private static boolean ifWordExists(char[][] board, String word){
        if (board == null || word.isEmpty()) return false;

        if (board.length * board[0].length < word.length()) return false;

        for (int i =0; i < board.length; i++){
            for (int j =0; j< board[0].length; j++){
                if (backtrack(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    private static boolean canFormAnagram(char[][] board, String targetWord){
        Map<Character, Integer> targetWordFreqMap = new HashMap<>();
        for (char c: targetWord.toCharArray()){
            targetWordFreqMap.merge(c, 1, Integer::sum);
        }
        Map<Character, Integer> boardFreqMap = new HashMap<>();
        for (char[] row: board){
            for (char c: row){
                boardFreqMap.merge(c, 1, Integer::sum);
            }
        }
        for (Map.Entry<Character, Integer> entry: targetWordFreqMap.entrySet()){
            char currentCharacter = entry.getKey();
            int req = entry.getValue();

            if (boardFreqMap.getOrDefault(currentCharacter, 0) < req){
                System.out.println("Need char "+ currentCharacter+" to have freq: "+req+ " and hence pruning");
                return false;
            }
        }
        return expensiveBackTracking(board, targetWord, 0, 0, 0);


    }

    private static boolean expensiveBackTracking(char[][] board, String targetString, int index, int row, int col){
        if (index == targetString.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '#') return false;
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found = expensiveBackTracking(board, targetString, index+1, row+1, col) ||
                expensiveBackTracking(board, targetString, index+1, row-1, col) ||
                expensiveBackTracking(board, targetString, index+1, row, col+1) ||
                expensiveBackTracking(board, targetString, index+1, row, col-1);
        board[row][col] = temp;
        return found;
    }

    private static boolean backtrack(char[][] board, String word, int row, int col, int index){
        if (index == word.length()) return true;

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) return false;

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = backtrack(board, word, row+1, col, index+1) ||
                backtrack(board, word, row-1, col, index+1) ||
                backtrack(board, word, row, col+1, index+1) ||
                backtrack(board, word, row, col-1, index+1);
        board[row][col] = temp;
        return found;
    }

    public static void main(String[] args) {
        char[][] chars = {{'a', 'b', 'c', 'd'}, {'s', 'a', 'a', 'o'}, {'z', 't', 't', 'g'} };
        long start = System.currentTimeMillis();
        System.out.println(ifWordExists(chars, "ass"));
        System.out.println(ifWordExists(chars, "bat"));
        System.out.println(ifWordExists(chars, "cat"));
        System.out.println(ifWordExists(chars, "dog"));
        System.out.println(ifWordExists(chars, "sggfsngj"));
        System.out.println(ifWordExists(chars,"zebra"));
        System.out.println("time taken: "+(System.currentTimeMillis()- start)+ " ms");
    }
}
