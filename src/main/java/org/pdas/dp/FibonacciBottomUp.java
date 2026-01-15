package org.pdas.dp;

public class FibonacciBottomUp {
    public static int fibTabulation(int n) {
        if (n <= 1){
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1]+ dp[i-2];
        }
        return dp[n];

    }

    private static int fibOptimized(int n){
        if (n <= 1){
            return n;
        }
        int prev2 = 0;
        int prev1 = 1;

        for (int i=2; i <=n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;

    }

    public static void main(String[] args) {
        int n = 5;
        long time = System.nanoTime();
         int res = fibTabulation(n);
//        int res = fibOptimized(n);
        long end = System.nanoTime();
        System.out.println("Result: "+res+" Time taken "+(end-time)/1000+ " micro sec");

    }
}
