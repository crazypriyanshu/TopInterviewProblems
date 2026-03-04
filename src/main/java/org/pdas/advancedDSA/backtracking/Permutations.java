package org.pdas.advancedDSA.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    private static ArrayList<ArrayList<String>> findPermutations(String[] arr){
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        int n = arr.length;
        boolean[] used = new boolean[n];

        backtrack(arr, new ArrayList<>(), result, used);
        return result;
    }

    private static void backtrack(String[] input, ArrayList<String> path, ArrayList<ArrayList<String>> result, boolean[] used){
        if (path.size() == input.length){
            result.add(new ArrayList<>(path));
            return;
        }

        if (path.size() > input.length){
            return;
        }

        for (int i = 0; i < input.length; i++) {
            if(used[i]) continue;
             if (i > 0 && input[i] == input[i-1] && !used[i-1]) return;
            path.add(input[i]);
            used[i] = true;
            backtrack(input, path, result, used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }

    private static boolean isValidPath(ArrayList<String> path, int[] ints){
        int n = ints.length;
        if (path.size() == n && path.contains(n)) return true;
        return false;

    }

    public static void main(String[] args) {
        String[] arr = {"A", "B", "C", "D"};
        var ans = findPermutations(arr);
        for (ArrayList<String> a: ans){
            a.forEach(System.out::print);
            System.out.println();

        }
    }
}
