package org.pdas.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Trie{
    private final TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }

    private static class TrieNode{
        private String word = null;
        private final TrieNode[] children = new TrieNode[26];
    }

    public void insert(String word){
        if (word == null || word.isEmpty()){
            return;
        }

        TrieNode curr = root;
        String newWord = word.toLowerCase();
        for (char c: newWord.toCharArray()){
            int index = c - 'a';
            if (index < 0 || index > 26) continue;
            if (root.children[index] != null){
                root.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.word = word;
    }

    public static TrieNode buildTrie(List<String> words){
        TrieNode root = new TrieNode();
        for (String word: words){
            TrieNode p = root;
            for (char c : word.toCharArray()){
                int index = c - 'a';
                if (p.children[index] == null){
                    p.children[index] = new TrieNode();
                }
                p = p.children[index];
            }
            p.word = word;
        }
        return root;
    }

    public static List<String> findWords(char[][] board, List<String> words){
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public static void dfs(char[][] board, int row, int col, TrieNode node, List<String> res){
        char c = board[row][col];
        int index = c - 'a';
        if (c == '#' || node.children[index] == null) return;
        node = node.children[index];
        if (node.word != null){
            res.add(node.word);
            node.word = null;
        }
        board[row][col] = '#'; // marking as visited

        if (row > 0) dfs(board, row-1, col, node, res);
        if (col > 0) dfs(board, row, col-1, node, res);
        if (row < board.length-1) dfs(board, row+1, col, node, res);
        if (col < board[0].length-1) dfs(board, row, col+1, node, res);

        board[row][col] = c; // make it back
    }

    /*
     * you are given a 2D char array
     * find the number of words
     *
     * approach: first store the words in trie data structure
     * and then compare word and trie
     * */

    public static void main(String[] args) {
        char[][] board = {{'a', 'a', 's'},
                {'b', 'a', 's'},
                {'c', 'a', 's'}};
        List<String> words = List.of("bas", "ama");
        findWords(board, words).stream().forEach(System.out::println);

    }
}
