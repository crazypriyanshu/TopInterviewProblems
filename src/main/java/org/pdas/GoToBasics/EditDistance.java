package org.pdas.GoToBasics;

public class EditDistance {

    private static int findMinCost(String s1, String s2){
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) return -1;

        int s1Length = s1.length();
        int s2Length = s2.length();

        int[][] dp = new int[s1Length+1][s2Length+1];

        for (int row = 0; row <= s1Length; row++) {
            dp[row][0] = row;
        }

        for (int col = 0; col <= s2Length; col++) {
            dp[0][col] = col;
        }

        for (int row = 1; row <= s1Length; row++) {
            for (int col = 1; col <= s2Length; col++) {
                if (s1.charAt(row-1) == s2.charAt(col-1)){
                    dp[row][col] = dp[row-1][col-1];
                } else {
                    int insert = dp[row][col-1];
                    int delete = dp[row-1][col];
                    int replace = dp[row-1][col-1];
                    dp[row][col] = 1+ Math.min(insert, Math.min(delete, replace));
                }

            }
        }
        return dp[s1Length][s2Length];
    }

    public static void main(String[] args) {
        String s1 = "CODA";
        String s2 = "CODE";
        System.out.println(s1.substring(2).equalsIgnoreCase(s1));

        //System.out.println(findMinCost(s1, s2));
    }
}
