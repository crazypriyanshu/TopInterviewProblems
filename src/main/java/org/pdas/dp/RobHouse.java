package org.pdas.dp;

public class RobHouse {
    /**
     * Given an array where arr[i] = amount of money  one robber can rob from particular house.
     * Given that a robber can't rob from 2 adjacent house
     * */
    private static int n = 0;
    private static int recursiveRob(int[] arr, int curr){
        if (curr >= arr.length) return 0;
        int robCurr = arr[curr] + recursiveRob(arr, curr+2);
        int notRob = recursiveRob(arr,curr+1);

        return Math.max(robCurr, notRob);
    }

    private static int dpRob(int[] arr){
        if (arr == null) return -1;
        int n = arr.length;
        if (n == 1) return arr[n];


        int rob = arr[0];
        int notRob = Math.max(arr[0], arr[1]);
        int maxTillNow = 0;
        for (int i = 2; i < n; i++) {
            maxTillNow = Math.max(arr[i]+rob, notRob);
            rob = notRob;
            notRob = maxTillNow;
        }

        return maxTillNow;

    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 9, 3, 1};
        //
        System.out.println(dpRob(arr));
    }
}
