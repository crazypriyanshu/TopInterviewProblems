package org.pdas.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int lengthOfLongestIncreasingSubsequence(int[] nums){
        // given a list of integers, we need to find the length of longest increasing subsequence
        if (nums == null || nums.length ==0){
            return 0;
        }

        List<Integer> subSequence = new ArrayList<>();
        for (int num: nums){
            int pos = binarySearch(subSequence, num);
            if (pos == subSequence.size()){
                subSequence.add(num);
            } else {
                subSequence.set(pos, num);
            }
        }
        return subSequence.size();

    }
    public static int binarySearch(List<Integer> subsequence, int target){
        int low =0, high = subsequence.size()-1;
        while (low <= high){
            int mid = low+ (high - low)/2;
            if (subsequence.get(mid) == target){
                return mid;
            } else if (subsequence.get(mid) < target){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length "+ lengthOfLongestIncreasingSubsequence(nums));
    }
}
