package org.pdas.arrays;

import java.util.Arrays;
import java.util.Map;

/**
 * SuperArray : Given two array list int[] A of len=n and int[] B of len M.
 * SuperArray is defined as sorted array obtained after merging all the possible subArrays of A
 * Now we have to return int[] C of len M, where C[i] = value of B[i] index in superArray of A
 *
 * Merging all possible subArrays of A =>
 * We need to find kth-smallest element B[i] in the set of all possible subArray sums
 *
 * set of all possible subArray sums: range : min(A) to sum(A) (can do binary search)
 *
 * Now, we need to count subArray with sum less than X(B[i]): we have to count -
 * how many subArrays are there with count < X(B[i]) : find this in O(N) TC using sliding window two pointer approach
 * Binary search the smallest X such that count of subArrays with sum <= X
 *
 *
 * */
public class SuperArrays {

    private static int[] superArray(int[] A, int[] B){
        int N = A.length;
        int M = B.length;

        int[] C = new int[M];
        Arrays.fill(C, -1);

        // find low and high
        int low = 0, high = 0;
        int min = Integer.MAX_VALUE;
        int totSum = 0;

        for (int num: A){
            min = Math.min(min, num);
            totSum += num;
        }

        low = min;
        high = totSum;

        // we found range

        for (int i =0; i < M; i++){
            C[i] = findSubArrayCountLessThan(A, B[i], low, high);
        }
        return C;
    }

    /**
     * Responsibility of this method is to return count of subArray sums < k
     * */
    private static int findSubArrayCountLessThan(int[] arr, int k, int low, int high) {
        int ans = low;
        while (low <= high){
            int mid = low + (high-low)/2;
            if(countSubArray(mid, arr) >= k){
                ans = mid;
                high = mid-1;

            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    /**
     * should return count of subArray sum <= mid
     * */
    private static int countSubArray(int mid, int[] arr) {
        int count=0;
        int left = 0;
        int currSum = 0;

        for (int right = 0; right < arr.length; right++) {
            currSum += arr[right];
            while (currSum > mid && left <= right){
                currSum -= arr[left];
                left++;
            }
            count += (right-left+1);
        }
        return count;
    }

    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4};
        int[] B = {2, 7};
        Arrays.stream(superArray(A, B)).forEach(System.out::println);

    }

}