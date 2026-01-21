package org.pdas.dp.dpOnStrings;

import java.util.Arrays;

public class EditDistance {
    /*
    * Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
    * You have the following 3 operations permitted on a word:
    * Insert a character
    * Delete a character
    * Replace a character
    *
    * let's say if we have String S1 = "ABC" and String S2 = "AEE"
    * let's store the state in dp[][] , where dp[i][j] = min cost to convert first i chars of S1 to first j chars of S2
    * so, if(s1.charAt(i-1) != s2.charAt(j-1)) then we must choose 3 options : replace, delete, insert
    * now, if we want to make S1 == S2, then we start checking S1.charAt(i) == S2.charAt(j) - if they are equal then no cost incurred, but
    * if they are unequal then we can either delete, replace or insert
    * if we insert in S2: then S2 gets shorter, cost of insert=  dp[i][j-1]
    * if we delete from S1: then S1 gets shorter and then cost of deletion = 1 + dp[i-1][j]
    * if we replace both from S1 and S2: then cost of replacement = 1 + dp[i-1][j-1] -> both strings get shorter
    *
    * We can solve this using 3 approaches:
    * 1. Top-down approach : Recursion + Memoization
    * 2. Bottom-up approach : Tabulation
    * 3. Space optimized, bottom-up approach - two row array
    * */


    // recursion:
    static int[][] memo;
    private static int topDownApproach(String s1, String s2){
        if (s1 == null) {
            return s2.length();
        }
        if (s2 == null){
            return s2.length();
        }
        int n = s1.length();
        int m = s2.length();
        memo = new int[n+1][m+1];
        for (int[] row: memo){
            Arrays.fill(row, -1);
        }

        return solveUsingMemoization(s1, s2, n, m);
    }

    // recursive solution
    // TC: O(3^(n+m)) , SC: O(n+m)
    private static int solveUsingMemoization(String s1, String s2, int row, int col){
        if (row == 0) return col; // base case: s1 is empty
        if (col == 0) return row; // base case: s2 is empty
        if (memo[row][col] != -1){
            return memo[row][col];
        }

        if (s1.charAt(row-1) == s2.charAt(col-1)){
            // case where S1 and S2 are equal, we are not adding anything and simply taking the value from the above diagonal
            return memo[row][col] = solveUsingMemoization(s1, s2, row-1, col-1);
        } else {
            int insert = solveUsingMemoization(s1, s2, row, col-1);
            int delete = solveUsingMemoization(s1, s2, row-1, col);
            int replace = solveUsingMemoization(s1, s2, row-1, col-1);
            return memo[row][col] = 1 + Math.min(insert, Math.min(delete, replace));
        }
    }

    // solve this problem using tabular
    // TC: O(n*m) , SC: O(n*m)
    private static int solveUsingTabular(String s1, String s2){
        if (s1 == null|| s2 == null){
            return -1;
        }
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m ; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    // means both are equal
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];
                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }

            }

        }
        return dp[n][m];
    }

    // more optimized
    // TC: O(n*m), SC: O(M)
    private  static int solveOptimized(String s1, String s2){
        if (s1 == null || s2 == null){
            return -1;
        }
        int n = s1.length();
        int m = s2.length();

        int[] current = new int[m+1];
        int[] previous = new int[m+1];

        for (int i = 0; i <= m; i++) {
            // initialize only 1st row
            previous[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            current[0] = i;
            for (int j = 1; j <= m ; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    current[j] = previous[j-1];
                } else {
                    int delete = previous[j];
                    int insert = current[j-1];
                    int replace = previous[j-1];
                    current[j] = 1 + Math.min(delete, Math.min(insert, replace));
                }
            }
            System.arraycopy(current,0, previous, 0, m+1);
        }
        return current[m];


    }

    public static void main(String[] args) {
        String s1 = "britcandy";
        String s2 = "andy";
        // instantiate memo
        memo = new int[s1.length()+1][s2.length()+1];
        Arrays.stream(memo).forEach(row -> Arrays.fill(row, -1));
         System.out.println(solveUsingMemoization(s1, s2, s1.length(), s2.length()));
        System.out.println(solveUsingTabular(s1, s2));
        System.out.println(solveOptimized(s1, s2));
    }
}
