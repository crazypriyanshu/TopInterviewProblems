package org.pdas.arrays.mostAskedProblems;

import java.util.*;

public class AutoComplete {
    /**
     * Trie Node: contains
     * 1. a map of Character and TrieNode
     * 2. List of words that this node contains
     * */
    public static class TrieNode{
        private final Map<Character, TrieNode> children;
        private final ArrayList<Integer> topWordIndices;
        TrieNode(){
            this.children = new HashMap<>();
            this.topWordIndices = new ArrayList<>();
        }

        /**
         * Update top words
         * for which word index in dictionary
         * */
        public void updateTopWords(int wordIndex, ArrayList<Integer> weight){

            topWordIndices.add(wordIndex);

            topWordIndices.sort((a, b) -> {
                if (weight.get(a).equals(weight.get(b))) return 0;
                return (weight.get(a) < weight.get(b)) ? 1 : -1;
            });
            if (topWordIndices.size() > 5){
                topWordIndices.remove(5);
            }
        }
    }

    /**
     * Method to insert a word
     * starts with root, find the children -> move to child and repeat the same process
     * also call updateTopWords
     * */
    private static void insertWord(TrieNode root, String word, ArrayList<Integer> weights, int wordIndex){
        for (char c: word.toCharArray()){
            root.children.putIfAbsent(c, new TrieNode());
            root = root.children.get(c);
            root.updateTopWords(wordIndex, weights);
        }
    }

    /**
     *
     * */
    private static void searchPrefix(TrieNode root, String prefix, List<String> dictionary){
        TrieNode curr = root;
        for (char ch: prefix.toCharArray()){
            if (!curr.children.containsKey(ch)){
                System.out.println("-1");
            }
            curr = curr.children.get(ch);
        }

        for (int index: curr.topWordIndices){
            System.out.println(dictionary.get(index));
        }
        System.out.println();
    }
    /**
     * There is a dictionary A of N words, and ith word has a unique weight Wi.
     * Another string array B of size M contains the prefixes.
     * For every prefix B[i], output at most 5 words from the dictionary A that start with the same prefix.
     * Output the words in decreasing order of their weight.
     *
     * NOTE: If there is no word that starts with the given prefix output -1.
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println(n);

        ArrayList<String> dictionary = new ArrayList<>();
        dictionary.addAll(List.of("abcd", "aecd", "abaa", "abef", "acdcc", "acbcc"));
        ArrayList<Integer> weights = new ArrayList<>();
        weights.addAll(List.of(2, 1, 3, 4, 6, 5));
        ArrayList<String> prefixes = new ArrayList<>();
        prefixes.addAll(List.of("ab","abc", "a"));

        TrieNode root = new TrieNode();
        for (int i=0; i < dictionary.size(); i++){
            String word = dictionary.get(i);
            insertWord(root, word, weights, i);
        }
        for (String prefix: prefixes){
            searchPrefix(root, prefix, dictionary);
        }

    }
}
