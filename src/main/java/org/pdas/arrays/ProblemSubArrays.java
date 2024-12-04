package org.pdas.arrays;

import java.util.HashMap;
import java.util.Map;

public class ProblemSubArrays {
    // find total numbers of subarray whose sum is equal to k
    public static int subArraySum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0, sum = 0;

        for (int num: nums){
            sum += num;
            if (map.containsKey(sum - target)){
                count += map.get(sum-target);
            }
            map.put(sum, map.getOrDefault(sum, 0) +1);
        }
        return count;

    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 8, 10};
        int target = 10;
        System.out.println(subArraySum(nums, target));
    }
}
