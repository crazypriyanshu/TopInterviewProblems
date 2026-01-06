package org.pdas.arrays.twoPointers;

public class CountPairSumTarget {
    // Count pairs with sum < target
    private static int countOfPairsLesserThanTarget(int[] arr, int target){
        int left = 0;
        int right = arr.length -1;
        int count = 0;

        while (left < right){
            int sum = arr[left] + arr[right];
            if (sum < target){
                count++;
            }
            if (sum < target){
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {5, 15, 20, 21};
        int target = 41;
        System.out.println(countOfPairsLesserThanTarget(arr, target));

    }
}
