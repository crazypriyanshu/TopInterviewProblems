package org.pdas.popularInterview.Arrays;

public class MaxSumOfContiguousArray {
    /*
    * You have been given a array for positive and negative integers
    * We need to find the maxSum of contiguous array
    * */

    private static int findMaxSum(int[] arr){
        if (arr == null) return 0;
        if (arr.length == 1) return arr[0];

        int currSum = 0, n = arr.length;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += arr[i];
            maxSum = Math.max(currSum, maxSum);
            if (currSum < 0){
                currSum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr= {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(findMaxSum(arr));
    }
}
