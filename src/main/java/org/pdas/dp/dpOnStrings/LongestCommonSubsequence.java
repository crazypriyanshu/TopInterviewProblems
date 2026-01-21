package org.pdas.dp.dpOnStrings;

import java.util.Arrays;

public class LongestCommonSubsequence {
    /*
    * Given two strings A and B.
    * Find the longest common subsequence ( A sequence which does not need to be contiguous),
    * which is common in both the strings.
    * You need to return the length of such longest common subsequence.
    * */

    private static int solveLCS(String A, String B){
        if (A == null || B == null){
            return 0;
        }

        int n = A.length();
        int m = B.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <=m ; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    // no match
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    // solve using bottom up approach:
    private static int findLCSBottomUp(String s1, String s2){
        if (s1 == null || s2 == null){
            return 0;
        }
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }

        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String A = "ABDAA";
        String B = "AACAA";
        System.out.println(findLCSBottomUp(A, B));
//        System.out.println(solveLCS(A,B));
    }
}
