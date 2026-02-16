package org.pdas.popularInterview;

import java.util.Arrays;

public class EquibriumArrayIndex {
    /*
    * we have to find the equilibrium array index is index where - sum of left sides = sum of right side indexes
    * */

    private static int findEquilibriumIndex(int[] arr){
        if (arr == null) return 0;
        int n = arr.length;
        if (n == 1) return 1;

        long totSum = Arrays.stream(arr).sum();
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (leftSum == (totSum - leftSum - arr[i])){
                return i;
            }
            leftSum += arr[i];

        }
        return -1;

    }

    public static void main(String[] args) {
        int[] A = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(findEquilibriumIndex(A));
        System.out.println(findEquilibriumSumUsingPrefixSum(A));
    }

    private static int findEquilibriumSumUsingPrefixSum(int[] arr){

        if (arr == null) return 0;
        int n = arr.length;
        if (n == 1) return 1;

        long[] prefixSum = new long[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1]+arr[i];
        }

        long totalSum = prefixSum[n-1];
        for (int i = 0; i < n; i++) {
            long leftSum = (i == 0)? 0 : prefixSum[i-1];
            long rightSum = totalSum - leftSum -arr[i];
            if (leftSum == rightSum){
                return i;
            }

        }
        return -1;
    }
}
