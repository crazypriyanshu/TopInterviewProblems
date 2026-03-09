package org.pdas.Strings;

import java.util.Arrays;

public class MinimumWindowSubString {
    /**
     * Given 2 string S and T of length m and n respectively
     * Return minimum window subString such that every character of in T is included in the window, if there is no such string return empty string
     * Eg. S = "ADOBECODEBANC" and T = "ABC"
     * return "ADOBEC" and "BANC" - both contains "ABC" ~ T
     * */
    private static String minWindowSubString(String S, String T){
        if (S == null || T == null) return "";
        if (S.length() < T.length()) return "";

        int start = 0;

        int[] need = new int[128];
        Arrays.fill(need, -1);

        for (char ch: T.toCharArray()){
            need[ch]++;
        }

        int count = T.length();
        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < S.length()){
            char ch = S.charAt(right);
            if (need[ch] > 0){
                count--;
            }
            need[ch]--;
            right++;
            while (count == 0){
                if (right - left < minLen){
                    start = left;
                    minLen = right-left;
                }
                char lch = S.charAt(left);
                need[lch]++;
                if (need[lch] > 0){
                    count++;
                }
                left++;
            }

        }

        return minLen == Integer.MAX_VALUE ? " ": S.substring(start, start+minLen);

    }

    public static void main(String[] args) {
        String S = "ABCD";
        String T = "AC";
        minWindowSubString(S, T);
    }
}
