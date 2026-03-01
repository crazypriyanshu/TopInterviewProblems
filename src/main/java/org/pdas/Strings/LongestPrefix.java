package org.pdas.Strings;

import java.util.Arrays;
import java.util.Map;

public class LongestPrefix {
    /**
     * Given a list of Strings, find out the longest common prefix
     * A = ["flower", "flora", "flat"]
     * ans should be 2 as only "fl" is common
     * */
    private static String findLongestPrefix(String[] sentence){
        if (sentence == null || sentence.length == 0) return "";
        if (sentence.length == 1) return sentence[0];
        StringBuilder sb = new StringBuilder();
        Arrays.sort(sentence);
        int n = sentence.length;
        String firstWord = sentence[0];
        String lastWord = sentence[n-1];
        int len = 0;

        for (int i = 0; i < Math.min(firstWord.length(), lastWord.length()); i++) {
            if (firstWord.charAt(i) == lastWord.charAt(i)){
                sb.append(firstWord.charAt(i));
                len++;
            } else {
                break;
            }
        }
        return sb.toString();
    }

    private static String findLongestPrefixOptimized(String[] sentence){
        if (sentence == null || sentence.length == 0){
            return "";
        }
        if (sentence.length == 1) return sentence[0];
        int n = sentence.length;

        Arrays.sort(sentence);
        String firstWord = sentence[0];
        String lastWord = sentence[n-1];
        int counter = 0;
        while (counter >= 0 && counter < firstWord.length() && counter < lastWord.length()){
            if (firstWord.charAt(counter) == lastWord.charAt(counter)){
                counter++;
            } else {
                return firstWord.substring(0, counter);
            }
        }
        return firstWord;
    }

    public static void main(String[] args) {
        String[] A = {"Flower", "Flora", "Flat"};
        System.out.println(findLongestPrefixOptimized(A));
    }
}
