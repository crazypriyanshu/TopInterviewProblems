package org.pdas.dp;

import java.util.Arrays;

public class LongestIncreasingSubString {
    /**
     *
     * Given an int[] arr, find the length of longest increasing subsequence
     * */
    private static int longestIncreasingSubString(int[] arr){
        if (arr == null || arr.length == 0) return 0;
        int[] dp = new int[arr.length + 1];
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]){
                    count = Math.max(count, dp[j]);
                }
            }
            dp[i] = count+1;
        }

        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2};
        System.out.println(longestIncreasingSubString(arr));
    }
}
