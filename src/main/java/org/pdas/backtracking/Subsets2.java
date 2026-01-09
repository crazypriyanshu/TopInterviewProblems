package org.pdas.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    // here in this problem, we are given an array of integers,
    // it may contain duplicates, we have to find the all possible unique subsets

    public static List<List<Integer>> subsets2(int[] arr){
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(0, arr, new ArrayList<>(), res);
        return res;

    }

    private static void backtrack(int start, int[] arr, List<Integer> path, List<List<Integer>> res){
        // every path is valid subset
        res.add(new ArrayList<>(path));

        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i-1]){
                continue;
            }
            path.add(arr[i]);
            backtrack(i+1, arr, path, res);
            path.remove(path.size()-1);
            
        }
    }



    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        // output = {{}, {1}, {1, 2}, {1, 2, 2}, {2}, {2, 2}}
        subsets2(arr).stream().forEach(System.out::println);


    }

}
