package org.pdas.arrays.subarrays;

import java.util.TreeMap;

/**
 * Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
 * 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
 * 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
 * Your task is to find the count of good subarrays in A.
 * */
public class GoodSubArrays {
    public static void countGoodSubArrays(int[] A, int B){
        int n = A.length;
        long[] prefix = new long[n+1];

        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + A[i];
        }

        // two tree maps to store frequencies of prefixSum based on index parity
        TreeMap<Long, Integer> evenPrefixCounter = new TreeMap<>();
        TreeMap<Long, Integer> oddPrefixCounter = new TreeMap<>();

        evenPrefixCounter.put(0L, 1);
        int ans = 0;

//        for (int j = 0; j < n; j++) {
//            long currPrefix = prefix[j+1];
//            int currIndexParity = (j+1)%2;
//
//            if (currIndexParity == 0) { // (j+1) is even
//                ans +=
//            }
//        }
    }

    private static int getCountGreaterThan(TreeMap<Long, Integer> map, long target){
        int count = 0;
        // Tail map gets all keys strictly greater than target
        for (int val: map.tailMap(target, false).values()){
            count += val;
        }
        return count;
    }

    private static int getCountLessThan(TreeMap<Long, Integer> map, long target){
        int count = 0;

        for (int val: map.headMap(target, false).values()){
            count += val;
        }
        return count;
    }
}
