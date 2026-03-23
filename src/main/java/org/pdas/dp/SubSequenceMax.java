package org.pdas.dp;

public class SubSequenceMax {
    /**
     * Given n-array element, find the max subsequence sum, please note that we can't take 2 adjacent elements
     *
     * */
    private static int findMaxSubSequenceSum(int[] arr){
        int[] dp = new int[arr.length+1];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for (int i = 2; i < arr.length ; i++) {

            dp[i] = Math.max(dp[i-1], arr[i]+dp[i-2] );
        }
        return dp[arr.length-1];
    }

    private static int findMax(int[] arr){
        int prev2 = 0;
        int prev1 = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int curr = Math.max(prev1, prev2+ arr[i]);
            prev2 = prev1;
            prev1 = curr;

        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 7, 3, 11};
        System.out.println(findMaxSubSequenceSum(arr));
        System.out.println(findMax(arr));
    }
}
