package org.pdas.popularInterview;

import java.io.PrintStream;

public class MaxPossibleSum {
    /*
    * You are given an Integer array of size N.
    * You have to perform B operations.
    * In one operation we can either remove leftMost or rightMost element of A
    * Return max possible sum we can get for doing B operations
    * */

    public static int pickFromBothEnds(int[] A, int B){
        if (A == null || A.length < B || A.length == 0) return 0;
        int n = A.length;
        int currSum = 0;

        for (int i = 0; i < n; i++) {
            currSum += A[i];
        }

        int maxSum = currSum;

        int leftIndex = B-1;
        int rightIndex = n-1;

        while (leftIndex >= 0){
            currSum = currSum - A[leftIndex] + A[rightIndex];
            maxSum = Math.max(maxSum, currSum);
            leftIndex--;
            rightIndex--;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 5, 6, 7, -1, -3, 2, 1};
        int B = 3;
        System.out.println(pickFromBothEnds(A, B));
    }
}
