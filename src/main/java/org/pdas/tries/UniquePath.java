package org.pdas.tries;

import java.util.Arrays;

public class UniquePath {
    /*
    * Given a list of N words, find the shortest unique prefix to represent each word in the list.
    * NOTE: Assume that no word is the prefix of another.
    *  In other words, the representation is always possible
    * */

    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int count = 0; // to track the count for uniqueness
    }

    private static TrieNode root = new TrieNode();

    private static void insert(String word){
        if (word.length() == 0 || word.isEmpty()) return;
        TrieNode current = root;
        for (char c: word.toCharArray()){
            int index = c - 'a';
            if (current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
            current.count++;
        }
    }

    private static String findPrefix(String word){
        if (word.isEmpty() || word.length() == 0) return "";
        TrieNode current = root;
        StringBuilder sb = new StringBuilder();
        for (char c: word.toCharArray()){
            sb.append(c);
            current = current.children[c-'a'];
            if (current.count == 1) return sb.toString();
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        String[] wordList = {"zebra", "dog", "duck", "dove"};

        for (String word: wordList){
            insert(word);

        }
        String[] res = new String[wordList.length];
        for(int i=0; i < wordList.length; i++){
            res[i] = findPrefix(wordList[i]);
        }

        Arrays.stream(res).forEach(System.out::println);

    }
}
