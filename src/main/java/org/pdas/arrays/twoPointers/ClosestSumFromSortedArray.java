package org.pdas.arrays.twoPointers;

public class ClosestSumFromSortedArray {
    /*
    * Given two sorted arrays of distinct integers, A and B, and an integer C,
    * find and return the pair whose sum is closest to C and the pair has one element from each array.
    * More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.
    * If there are multiple solutions find the one with minimum i and
    * even if there are multiple values of j for the same i then return the one with minimum j.
    * Return an array with two elements {A[i], B[j]}.
    * */

    private static int[] findClosestSum(int[] A, int[] B, int C) {
        int i = 0;
        int j = B.length-1;
        int minDiff = Integer.MAX_VALUE;
        int[] result = {A[i], B[j]};

        while (j >= 0 || i <= A.length-1){
            int currSum = A[i] + B[j];
            int currDiff = Math.abs(currSum - C);
            if (currSum < minDiff){
                minDiff = currDiff;
                result[0] = A[i];
                result[1] = B[j];
            }
            if (currSum > C){
                j--;
            } if ( currSum < C){
                i++;
            }
            if (currSum == C){
                result[0] = A[i];
                result[1] = B[j];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 4, 6, 8};
        int C = 9;
        int[] res = new int[2];
        res = findClosestSum(A, B, C);
        System.out.println(res[0]+ "  "+ res[1]);

    }
}
