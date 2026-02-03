package org.pdas.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /*
    * Find the longest increasing subsequence of a given array of integers, A.
    * A = [1, 2, 1, 5] - Longest increasing subsequence is : 1, 2, 5
    * */

    private static int longestIncreasingSubsequence(int[] arr){
        if (arr.length == 0) return 0;

        int n = arr.length;
        int[] dp = new int[n];
        int maxLen = 1;

        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <i; j++) {
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }

            }
            maxLen = Math.max(maxLen, dp[i]);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(longestIncreasingSubsequence(arr));
    }
}
