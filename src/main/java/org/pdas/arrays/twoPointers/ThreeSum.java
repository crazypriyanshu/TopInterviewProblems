package org.pdas.arrays.twoPointers;

import java.util.Arrays;

public class ThreeSum {
    /**
     * Given an integer array nums,
     * return all the triplets [nums[i], nums[j], nums[k]]
     * such that i != j, i != k, and j != k, and
     * nums[i] + nums[j] + nums[k] == 0
     * */
    private static int[] find3Sum(int[] arr){
        if (arr == null|| arr.length < 3) return new int[]{-1};
        int n = arr.length;

        Arrays.sort(arr);
        int[] res = new int[3];
        for (int i = 0; i < n-2; i++) {
            if (i > 0 && arr[i] == arr[i+1]) continue;
            int left = i+1;
            int right = n-1;
            while (left < right){
                int sum = arr[i]+ arr[left]+arr[right];
                if (sum > 0){
                    right--;
                } else if (sum == 0) {
                    return new int[]{i, left, right};
                } else {
                    left++;
                }

            }

        }
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 3, 0, 10};
        Arrays.stream(find3Sum(arr)).forEach(System.out::println);
    }
}
