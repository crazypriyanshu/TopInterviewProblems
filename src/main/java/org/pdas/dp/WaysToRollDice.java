package org.pdas.dp;

public class WaysToRollDice {
    /**
     *
     * You have been given a number N, count the number of ways we can get N, when we roll a dice.
     * you can roll a dice as many numbers as possible
     * */
    private static int findWays(int n){
        if (n < 0) return 0;
        if (n == 0) return 1;

        int[] dp = new int[n+1];
        dp[0] = 1; // number of ways to get 0 = 1
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                if (i - j >= 0){
                    dp[i] += dp[i-j];
                }
            }

        }
        return dp[n];


    }

    public static void main(String[] args) {
        System.out.println(findWays(16));
    }
}
