package org.pdas.dp;

public class KnapSackUnbounded {
    /**
     * Given n items, with weight and value, find max value which ca be obtained
     * by picking items, such that total weight is less than k(given)
     *
     * Eg: weight[] - {3, 6, 5, 2, 4}
     *      val[]   - {12, 20, 15, 6, 10}
     *      k = 8
     * */
    private static int findMaxVal(int[] values, int[] weight, int capacity){
        int[][] dp = new int[values.length+1][capacity+1];

        for (int i = 0; i <= values.length ; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0){
                    dp[i][j] = 0;
                } else {
                    int rejection = dp[i-1][j];
                    int selection = 0;
                    if (j - weight[i-1] >= 0){
                        selection = values[i-1] + dp[i-1][j- weight[i-1]];
                    }
                    dp[i][j] = Math.max(selection, rejection);
                }
            }
        }
        return dp[values.length][capacity];

    }

    public static void main(String[] args) {
        int[] values = {12, 20, 15, 6, 10};
        int[] weights = {3, 6, 5, 2, 4};
        int capacity = 8;
        System.out.println(findMaxVal(values, weights, capacity));
    }
}
