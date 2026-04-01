package org.pdas.dp;

import java.util.Arrays;

public class WaysToPairPeople {
    /**
     * Given N person, how many ways one can pair up with all the people
     *
     * */
    private static int findWaysToPair(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i-1] + dp[i-2]*(i-1);
        }
        return dp[n];
    }

    private static int findWaysToPairRecursively(int n){
        if (n == 0 || n == 1) return 1;
        if (memo[n] != -1) return memo[n];
        memo[n] = findWaysToPair(n-1)+ findWaysToPair(n-2)*(n-1);
        return memo[n];
    }

    private static int[] memo;

    public static void main(String[] args) {
        int n = 5;


        memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println(findWaysToPairRecursively(n));
    }
}
