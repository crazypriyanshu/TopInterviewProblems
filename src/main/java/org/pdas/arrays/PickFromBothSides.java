package org.pdas.arrays;

public class PickFromBothSides {
    /**
     * You are given an integer array A of size N.
     * You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
     * Find and return the maximum possible sum of the B elements that were removed after the B operations.
     *
     * Approach:
     * */
    private static int pickFromBothSides(int[] A, int B){
        int n = A.length;
        int windowSize = n-B;
        int currWindowSum = 0;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += A[i];
            if (i < windowSize){
                currWindowSum += A[i];
            }
        }

        if (windowSize == 0) return totalSum;
        int minWindowSum = currWindowSum;

        for (int i = windowSize; i < n; i++) {
            int cur = A[i];
            int lesCurr = A[i-windowSize];
            currWindowSum += cur-lesCurr;
            minWindowSum = Math.min(currWindowSum, minWindowSum);

        }
        return totalSum - minWindowSum;
    }

    public static void main(String[] args) {
        int[] arr = {5, -2, 3, 1, 2};
        int B = 3;
        System.out.println(pickFromBothSides(arr, B));
    }
}
