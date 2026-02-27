package org.pdas.backtracking;

import java.util.*;

public class Combinations2 {
    // problem : Given a collection of candidate numbers (may contain duplicates) and a target number,
    //return all unique combinations where the numbers sum to target.


    public static List<List<Integer>> combinations2(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, candidates, target, 0, new ArrayList<>(), result);
        return result;

    }

    private static void backtrack(int start, int[] candidates, int target, int sum, List<Integer> path, List<List<Integer>> res) {
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }

        if (sum > target){
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // because candidates is sorted and we check if i > start and then we check if that the one we added just now is not a duplicate and if it is we dont want to do any backtracking
            if (i > start && candidates[i] == candidates[i-1]){
                //don't do anything - just continue
                continue;
            }
            path.add(candidates[i]);
            backtrack(i+1, candidates, target, sum+candidates[i], path, res);
            path.remove(path.size()-1);
        }

    }


    public static void main(String[] args) {
        int[] numbers = {10,1,2,7,6,1,5};
        int target = 8;
        combinations2(numbers, target).stream().forEach(System.out::println);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Collections.sort(A);
        backstrack(A, B, res, new ArrayList<Integer>(), 0, 0);
        return res;

    }

    private static void backstrack(ArrayList<Integer> A, int B, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int currSum, int start){
        if (B == currSum){
            result.add(new ArrayList<>(path));
            return;
        }
        if (currSum > B){
            return;
        }

        for (int i = start; i < A.size(); i++) {
            int num = A.get(i);
            if (currSum +num > B) break;
            if (i > start && A.get(i).equals(A.get(i-1))) continue;
            path.add(A.get(i));
            backstrack(A, B, result, path, currSum+A.get(i), i);
            path.remove(path.size()-1);

        }


    }
}
