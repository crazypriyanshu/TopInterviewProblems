package org.pdas.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Integer, Integer> map = new HashMap<>();
    private static int fibonacci(int n, int[] dp){
        if (n <= 1){
            return n;
        }
        if (dp[n] != -1) return dp[n];
        dp[n] = fibonacci(n-1, dp)+ fibonacci(n-2, dp);
        return dp[n];
    }

    public static void main(String[] args) {

        int n = 25;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        long time = System.nanoTime();
        int res = fibonacci(n, dp);
        System.out.println("Fibonacci :  "+ res +" :"+(System.nanoTime()-time)/1000+ " micro sec");
    }
}
