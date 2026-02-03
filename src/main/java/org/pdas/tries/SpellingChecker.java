package org.pdas.tries;

import java.util.Arrays;

public class SpellingChecker {
    /*
    * Given an array of words A (dictionary) and another array B (which contain some words).
    * You have to return the binary array (of length |B|) as the answer where 1 denotes that the word is present in the dictionary and 0 denotes it is not present.
    * Formally, for each word in B, you need to return 1 if it is present in Dictionary and 0 if not.
    * Such problems can be seen in real life when we work on any online editor (like Google Documnet), if the word is not valid it is underlined by a red line.
    * NOTE: Try to do this in O(n) time complexity.
    * */

    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean word = false;
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
        }
        current.word = true;
    }

    private static int search(String word){
        if (word.length() == 0 || word.isEmpty()) return 0;
        TrieNode current = root;
        for (char c: word.toCharArray()){
            int index = c - 'a';
            if (current.children[index] == null) return 0;
            current = current.children[index];
        }
        return current.word ? 1: 0;
    }

    public static int[] solve(String[] wordDict, String[] searchWords){
        if (wordDict.length == 0 || searchWords.length == 0) {
            return new int[0];
        }

        for (String word: wordDict){
            insert(word);
        }
        int[] resPre = new int[searchWords.length];
        for (int i = 0; i < searchWords.length; i++) {
            resPre[i] = search(searchWords[i]);
        }
        return resPre;
    }

    public static void main(String[] args) {
        String[] wordList = {"hat", "cat", "rat" };
        String[] searchWordList = {"cat", "ball"};
        Arrays.stream(solve(wordList, searchWordList)).forEach(System.out::println);

    }
}
