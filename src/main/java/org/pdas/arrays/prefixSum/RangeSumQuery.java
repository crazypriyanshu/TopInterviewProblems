package org.pdas.arrays.prefixSum;

import java.util.Arrays;

public class RangeSumQuery {
    /**
     * You are given an integer array A of length N.
     * You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
     * For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
     * More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
     *
     * A = [1, 2, 3, 4, 5]
     * B = [[0, 3], [1, 2]]
     *
     * */
    private static int[] rangeSum(int[] arr, int[][] queries){
        int n = arr.length;
        int[] prefixSum = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i]+arr[i];
        }

        int index = 0;
        int[] res = new int[queries.length];
        for (int[] range: queries){
            int left = range[0];
            int right = range[1];
            int prefixSumTillRight = prefixSum[right+1];
            int prefixSumTillLeft = prefixSum[left];
            res[index++] = prefixSumTillRight-prefixSumTillLeft;

        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[][] queries = { {0,3}, {1,2}};
        var res = rangeSum(arr, queries);
        for (int r: res){
            System.out.println(r);
        }
    }
}
