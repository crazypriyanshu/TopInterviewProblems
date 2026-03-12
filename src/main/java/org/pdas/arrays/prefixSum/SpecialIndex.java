package org.pdas.arrays.prefixSum;

public class SpecialIndex {
    /**
     * Given an array, arr[] of size N, the task is to find the count of array indices
     * such that removing an element from these indices makes the sum of even-indexed
     * and odd-indexed array elements equal.
     *
     * Eg. arr = {2, 1, 6, 4}, if we remove 1, arr = {2, 6, 4} - which makes the even and odd sum 0
     *
     * {2, 3, 9, 13}, {13 ,11, 10,4}
     * prefix Sum of even and odd index - {2, 1, 8, 5}
     * if(i%2==0)
     * */
    private static int findSpecialIndex(int[] arr){

        int n = arr.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] prefixEven = new int[n];
        int[] prefixOdd = new int[n];

        int currentEven = 0, currentOdd=0;

        for (int i = 0; i < n; i++) {
            if (i%2 == 0){
                currentEven += arr[i];
            } else currentOdd += arr[i];
            prefixEven[i] = currentEven;
            prefixOdd[i] = currentOdd;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            // sum before index i
            int evenSumBefore = (i == 0) ? 0 : prefixEven[i-1];
            int oddSumBefore = (i == 0) ? 0: prefixOdd[i-1];
            // sum after index i even become odd and odd becomes even
            int evenSumAfter = prefixOdd[n-1] - prefixOdd[i];
            int oddSumAfter = prefixEven[n-1] - prefixEven[i];

            if (evenSumBefore + evenSumAfter == oddSumBefore + oddSumAfter){
                count++;
            }
        }

        return count;




    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 6, 4};
        findSpecialIndex(arr);

    }

}
