package org.pdas.dp.practice;

import java.util.Arrays;

public class LCS {
    private static int findLCS(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp){
            Arrays.fill(row, -1);
        }

        int index = 0;
        while (m >= 0 || n >= 0){
            if (n >= 0){
                dp[index][0] = 0;
            }

            if (m >= 0){
                dp[0][index] = 0;
            }
            index++;
            m--;
            n--;
        }

        for (int row = 1; row <= s1.length(); row++) {
            for (int col = 1; col <= s2.length() ; col++) {
                char ats1 = s1.charAt(row-1);
                char atS2 = s2.charAt(col-1);

                if (ats1 == atS2){
                    dp[row][col] = 1 + dp[row-1][col-1];
                } else {
                    dp[row][col] = Math.max(dp[row-1][col], dp[row][col-1]);
                }
            }

        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        while (len1 >0 && len2 > 0){
            if (s1.charAt(len1-1) == s2.charAt(len2-1) && (len1-1) >= 0){
                System.out.print(s1.charAt(len1-1));
                len1--;
                len2--;
            } else if ((dp[len1][len2] == dp[len1-1][len2]) && len1 >=1) {
                len1--;
            } else {
                len2--;
            }
        }
        System.out.println();
        
        return dp[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abchd";
        System.out.println("");
        System.out.println(findLCS(s1, s2));
    }
}
