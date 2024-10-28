package org.pdas.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// given an integer array, find 2 numbers that sum upto a specific sum
public class TwoSumProblem {
    public static int[] twoSum(int[] numberList, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< numberList.length; i++){
            int complement = target - numberList[i];
            if (map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            } else {
                map.put(numberList[i], i);
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 8};
        int target = 8;
        System.out.println();
        Arrays.stream(twoSum(nums, target)).forEach(i -> System.out.println(i));
    }
}
