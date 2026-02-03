package org.pdas.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets1 {

    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;

    }

    private static void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> result){
        // Every path is a valid subset
        result.add(new ArrayList<>(path));

        //lets extend the subset
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]); // choose
            backtrack(i+1, nums, path, result); // explore
            path.remove(path.size()-1); // unchoose

        }

    }

    public static List<List<String>> subsetsOfString(String[] strings){
        List<List<String>> res = new ArrayList<>();
        backtrackStrings(0, strings, new ArrayList<>(), res);
        return res;
    }

    private static void backtrackStrings(int start, String[] strings, List<String> path, List<List<String>> res){
        res.add(new ArrayList<>(path));
        for (int i = start; i < strings.length; i++){
            path.add(strings[i]);
            backtrackStrings(i+1, strings, path, res);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        // Given an array of distinct integers, return all possible subsets (the power set).
        int[] arr = {1, 2};
        // o/p - [[], [1], [2], [1, 2 ]]
        subsets(arr).stream().forEach(System.out::println);
        String[] strings = {"ab", "cd", "ef"};
        subsetsOfString(strings).stream().forEach(System.out::println);
    }
}
