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
        int n = 35;
//        System.out.println(climbStairs(n));
        System.out.println();
        System.out.println("Recursion way:");
        long start = System.currentTimeMillis();
        System.out.println(climbStairsRecursion(n));
        System.out.println("Time taken: "+(System.currentTimeMillis()-start)+" ms");

        System.out.println();
        System.out.println("Recursion way with memoization:");
        long start1 = System.currentTimeMillis();
        System.out.println(climbStairsRecursionMemoization(n));
        System.out.println("Time taken: "+(System.currentTimeMillis()-start1)+" ms");


        System.out.println();
        System.out.println("Iterative approach" +
                ": with n= 120");
        long start2 = System.currentTimeMillis();
        System.out.println((long) climbStairsIterativeWay(120));
        System.out.println("Time taken: "+(System.currentTimeMillis()-start2)+" ms");
    }

    /*
    * Climbing stairs - we can take either 1 step or 2 step
    * distinct ways of climbing stairs if i have 1 stair left - 1
    * distinct way of climbing stairs if we have 2 stairs - 2 (take 1 step + 1 step or take a 2 step)
    * so we know the last two ways
    *
    * most naive way - TC O(2^n)
    * */
    private static int climbStairsRecursion(int n){
        if (n <=2) return n;
        return climbStairsRecursion(n-1)+ climbStairsRecursion(n-2);
    }

    /*
    * Recursion with memoization
    * */
    private static int climbStairsRecursionMemoization(int n){
        if (n <=2) return n;
        int[] memo = new int[n+1];
        return helper(n, memo);

    }

    private static int helper(int n, int[] memo){
        if (n <= 2) return n;
        if (memo[n] != 0) return memo[n];

        memo[n] = helper(n-1, memo) + helper(n-2, memo);
        return memo[n];
    }

    private static int climbStairsIterativeWay(int n){
        if (n <= 2) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }



}
