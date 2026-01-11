package org.pdas.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsWithDuplicate {
    private static List<List<Integer>> permutationWithDuplicates(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), res, isUsed);
        return res;

    }

    private static void backtrack(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] isUsed){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) continue;

            if (i>0 && nums[i-1] == nums[i] && !isUsed[i-1]){
                continue;
            }
            isUsed[i] = true;
            path.add(nums[i]);
            backtrack(nums, path, res, isUsed);
            path.remove(path.size()-1);
            isUsed[i] = false;

        }
    }
    // here we can have duplicates as well
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        permutationWithDuplicates(arr).stream().forEach(System.out::println);
    }
}
