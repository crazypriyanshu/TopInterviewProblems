package org.pdas.tries;

import org.pdas.LLD.ElevatorSystem.interfaces.Panel;

public class ModifiedSearch {
    /*
    * Given two arrays of strings A of size N and B of size M.
    * Return a binary string C where C[i] = '1' if B[i] can be found in dictionary A using exactly one modification in B[i], Else C[i] = '0'.
    * NOTE: modification is defined as converting a character into another character.
    * */

    static class TrieNode{
        TrieNode[] child = new TrieNode[26];
        boolean isWord = false;
    }

    private static TrieNode root = new TrieNode();

    private static void insert(String word){
        if(word.length() == 0){
            return;
        }

        TrieNode curr = root;

        for(char c: word.toCharArray()){
            int index = c - 'a';
            if (curr.child[index] == null){
                curr.child[index] = new TrieNode();
            }

            curr = curr.child[index];

        }
        curr.isWord = true;
    }

    private static boolean canFindWithOneChange(String word, int index, boolean modified, TrieNode root){
        if(index == word.length()){
            return modified && root.isWord;
        }

        int newCharIndex = word.charAt(index) - 'a';
        for (int i = 0; i < 26; i++) {
            if (root.child[i] == null) continue;
            if (i == newCharIndex){
                if (canFindWithOneChange(word, index+1, modified, root)) return true;
            } else if (!modified){
                if (canFindWithOneChange(word, index+1, true, root)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] ListA = {"data", "circle", "cricket"};
        String[] ListB = {"date", "circel", "crikket", "data", "circl"};
        for (String word: ListA){
            insert(word);
        }

        StringBuilder sb = new StringBuilder();

        for (String word: ListB){
            if(canFindWithOneChange(word,0, false, root)){
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        System.out.println(sb.toString());
    }
}
