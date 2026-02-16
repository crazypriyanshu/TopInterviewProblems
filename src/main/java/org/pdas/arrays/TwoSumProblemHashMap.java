package org.pdas.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblemHashMap {
    public static void main(String[] args) {
        int[] arr = {7, 11, 3, 15};
        int target = 26;
        int[] ans = new int[2];
        ans = twoSum(arr, target);
        Arrays.stream(ans).forEach(System.out::println);

    }

    public static int[] twoSum(int[] arr, int target){
        if (arr.length == 0) return new int[]{0,0};
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int compliment = target - arr[i];
            if (map.containsKey(compliment)){
                return new int[]{compliment, i};
            }
            map.put(arr[i], i);
        }
        return new int[]{0,0};
    }
}
