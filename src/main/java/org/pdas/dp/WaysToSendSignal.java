package org.pdas.dp;

public class WaysToSendSignal {
    /**
     * Given n, find the binary numbers of length n, such that no 2 adjacent numbers are 1
     * */
    private static int sendSignal(int n){
        if (n == 0) return 0;
        if (n == 2) return 2;
        int[] dp = new int[n+1];
        int prev2 = 1;
        int prev1 = 2;
        int curr = 0;

        for (int i = 2; i <= n ; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            curr = prev1;

        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(sendSignal(5));
        System.out.println(tribonacciSeries(5));
    }
    /**
     * Given n , find the binary numbers of length n, digits such that no 3 adjacent 1's are possible
     * */
    private static int tribonacciSeries(int n){
        if (n == 0) return 1;
        if (n == 1) return 2;
        if (n == 2) return 4;

        int prev1 = 1;
        int prev2 = 2;
        int prev3 = 4;
        int curr = 0;
        for (int i = 3; i <= n ; i++) {
            curr = prev1 + prev2 + prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

}
