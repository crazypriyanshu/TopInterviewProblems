package org.pdas.maps;

import java.util.Arrays;

public class MinWindowSubString {

    private static String minWindowSubString(String s, String t){
        /*
        * Given 2 String s and t of length n and m
        * Find the length of min subString so that every character in t is present in S
        *
        * We will use expanding the window and then shrinking the window
        * We will make an integer[] 128 which can store all the 128 ASCII chars
        * */

        if (s.length() < t.length()) return " ";
        int start = 0, left = 0, right = 0, minLen = Integer.MAX_VALUE;
        int n = s.length();
        int[] need = new int[128];
        Arrays.fill(need, -1);

        for (char ch: t.toCharArray()){
            need[ch]++;
        }
        int count = t.length();

        while (right < n){
            char ch = s.charAt(right);
            if (need[ch] > 0){
                count--;
            }
            need[ch]--;
            right++;

            // when window is valid
            while (count == 0){
                if (right-left < minLen){
                    start = left;
                    minLen = right-left;
                }
                char leftChar = s.charAt(left);
                need[leftChar]++;
                if (need[ch] > 0){
                    count++;
                }
                left++;
            }

        }
        return minLen == Integer.MAX_VALUE ? " " : s.substring(start, start+minLen);
    }

    public static void main(String[] args) {
        String s = "ddaaabbca";
        String t = "abc";
        System.out.println(minWindowSubString(s, t));
    }
}
