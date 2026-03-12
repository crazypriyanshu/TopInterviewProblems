package org.pdas.dp;

import org.pdas.arrays.javaQ.A;

import java.util.Arrays;

public class LongestCommonSubSequence {
    /**
     * Given 2 String S1 & S2. you have to find the common subsequence
     * Eg: S1 = "abcdaf"
     * S2 = "acbcf"
     * the common subsequence here is "abcf"
     * Solution:
     * 1. We create a 2D array dp to store the state
     * 2. while traversing character by character between both the strings
     *      2.1 if that char-sequence(S1) is present in that subsequence(S2) = 1 + max(dp[i-1][j], dp[i][j-1])
     *      2.2 if that char-sequence(S1) is not present in that subsequence(S2) = max(dp[i-1][j], dp[i][j-1])
     * */
    private static int findLongestCommonSubsequence(String s1, String s2){
        if (s1 == null || s2 == null) return -1;
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1]; // rows*cols
        for (int[] rows: dp){
            Arrays.fill(rows, -1);
        }
        for (int row = 0; row <= n; row++) {
            dp[row][0] = 0;
        }
        for (int col = 0; col <= m; col++) {
            dp[0][col] = 0;
        }
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= m; col++) {
                char atS1 = s1.charAt(row-1);
                char atS2 = s2.charAt(col-1);
                if (atS1 == atS2){
                    dp[row][col] = 1 + dp[row-1][col-1];
                    // we cant add StringBuilder as we are not yet decided, we will get every pair that maches
                } else {
                    dp[row][col] = Math.max(dp[row][col-1], dp[row-1][col]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();

        while (n > 0 && m > 0){
            if (s1.charAt(n-1) == s2.charAt(m-1)){
                sb.append(s1.charAt(n-1));
                n--;
                m--;
            } else if (dp[n-1][m] > dp[n][m-1]) {
                n--;
            } else {
                m--;
            }
        }
        System.out.println("Out: "+ sb.reverse().toString());

        return dp[s1.length()][s2.length()];


    }

    public static void main(String[] args) {
        String s1 = "acbcf";
        String s2 = "abcdaf";
        System.out.println(findLongestCommonSubsequence(s1, s2));
    }
}
