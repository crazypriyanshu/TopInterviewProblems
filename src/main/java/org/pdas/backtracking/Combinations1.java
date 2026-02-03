package org.pdas.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations1 {
    // problem : given an array of distinct integers and target integer,
    // return all the unique combinations where the chosen number sums to target

    public static List<List<Integer>> combinationSum(int[] nums, int target){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, target, 0, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int start, int[] arr, int target, int sum, List<Integer> path, List<List<Integer>> res){
        if (sum == target){
            res.add(new ArrayList<>(path));
        }
        if (sum > target){
            return;
        }

        for (int i = start; i < arr.length; i++) {
            path.add(arr[i]);

            backtrack(i, arr, target, sum+arr[i], path, res); // reuse allowed
            path.remove(path.size()-1);

        }

    }


    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        // output = {{2, 2, 7}, {7}}
        // key idea: we recurse on sums and not the index
        combinationSum(candidates, target).stream().forEach(System.out::println);
    }
}
