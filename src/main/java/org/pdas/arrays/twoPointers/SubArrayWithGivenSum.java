package org.pdas.arrays.twoPointers;

public class SubArrayWithGivenSum {
    /*
    * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
    * If the answer does not exist return an array with a single integer "-1".
    * First sub-array means the sub-array for which starting index in minimum.
    * */

    private static int[] subArrayGivenSum(int[] arr, int target){
        int left = 0;
        long currSum = 0;

        for (int right = 0; right < arr.length; right++) {
            currSum += (long) arr[right];
            while (currSum > target && left < right){
                currSum = currSum-arr[left];
                left++;
            }
            if (currSum == target){
                int size = right - left +1;
                int[] res = new int[size];
                for (int i = 0; i < size; i++) {
                    res[i] = arr[left+i];
                }
                return res;
            }
        }
        return new int[]{-1};
        
    }

    public static void main(String[] args) {
        int[] A = {42,9,38,36,48,33,36,50,38,8,13,37,33,38,17,25,50,50,41,29,34,18,16,6,49,16,21,29,41,7,37,14,5,30,35,26,38,35,9,36,34,39,9,4,41,40,3,50,27,17,14,5,31,42,5,39,38,38,47,24,41,5,50,9,29,14,19,27,6,23,17,1,22,38,35,6,35,41,34,21,30,45,48,45,37};
        int B = 100;
        int[] res = subArrayGivenSum(A, B);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+ " | ");

        }
    }
}
