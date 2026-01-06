package org.pdas.arrays.twoPointers;

public class TwoPairBruteForce {
    // Given sorted array, find if a pair sums to target

    private static boolean twoSumBruteForce(int[] arr, int target){
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n ; j++) {
                int sum = arr[i] + arr[j];
                if ( sum == target){
                    return true;
                }
            }
        }
        return false;
    }

    /*
    * What we just did ? made the time complexity from n^2 to n
    * Learnings -
    *   1. sorted array gives us monotonic movement
    *   2. only pointer moves per iteration
    * */
    private static boolean twoSumUsing2PointerApproach(int[] arr, int target){

        int left = 0;
        int right = arr.length -1;

        while (left < right){
            int sum = arr[left] + arr[right];
            if (sum == target){
                return true;
            }
            if (sum > target){
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 20, 21};
        int target = 41;
        System.out.println(twoSumUsing2PointerApproach(arr, target));

    }
}
