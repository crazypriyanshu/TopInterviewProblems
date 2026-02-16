package org.pdas.dp.basics;

public class ClimbStarirs {
    /*
    * You are climbing a staircase that has n steps. Each time,
    * you can either take 1 step or 2 steps.
    * In how many distinct ways can you climb to the top?
    * */
    public static int climbStairs(int n){
        if (n < 2){
            return n;
        }

        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];

        }
        return dp[n];

    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }
}
