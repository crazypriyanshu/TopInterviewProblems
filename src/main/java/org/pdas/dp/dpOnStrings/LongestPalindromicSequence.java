package org.pdas.dp.dpOnStrings;

import java.util.Arrays;

public class LongestPalindromicSequence {
    /*
    * Given a string S, find the length of longest palindromic subsequence
    * Eg. "BBABCBCAB" - longest subsequence - BABCBAB Length = 7
    *
    * Simplest way would be - take String S, and reverse it and then find lcs
    * */

    // simple solution to find longest Common subsequence using tabular
    private static int longestPalindromicSubsequence(String s){
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        String reveresedString = sb.toString();

        //initialize start index
        for (int i = 0; i < n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i-1) == reveresedString.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]);
                }

            }

        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        String s = "BBABCBCAB";
        System.out.println(longestPalindromicSubsequence(s));
    }
}
