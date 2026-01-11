package org.pdas.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    // given int[] arr = {1, 2, 3}- give all the possible orders
    // for combinations - {1, 2} and {2, 1} - are same as we care about only set
    // for permutations - {1, 2} and {2, 1} - both are diff and valid

    private static List<List<Integer>> permutations(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        boolean[] isUsed = new boolean[arr.length];
        backtrack(arr, new ArrayList<>(), res, isUsed);
        return res;

    }

    private static void backtrack(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] isUsed){
        if (path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) continue;
            isUsed[i] = true;
            path.add(nums[i]);
            backtrack(nums, path, res, isUsed);
            path.remove(path.size()-1);
            isUsed[i] = false;

        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        // op = {1, 2, 3}, {2, 1, 3}, {3, 1, 2}, {2, 3, 1}, {3, 1, 2}, {1, 3, 2}...
        permutations(arr).stream().forEach(System.out::println);

    }


}
