package org.pdas.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinaryStrings {
    // Generate all binary strings of length n such that no two 1s are adjacent.
    // if n = 3 - > 000, 001, 010, 101, 100,

    private static List<String> generateBinaryStrings(int n){
        List<String> res = new ArrayList<>();
        // start loop from position 0, with base case: when pos == n
        backtrack(0, n, res, new StringBuilder());
        return res;
    }

    private static void backtrack(int pos, int n, List<String> res, StringBuilder path){
        if (pos == n){
            res.add(path.toString());
            return;
        }
        path.append('0');
        backtrack(pos+1, n, res, path);
        path.deleteCharAt(path.length()-1);
        if (pos == 0 || path.charAt(path.length()-1) != '1'){
            path.append('1');
            backtrack(pos+1, n, res, path);
            path.deleteCharAt(path.length()-1);
        }

    }

    public static void main(String[] args) {
        int n = 4;
        generateBinaryStrings(n).stream().forEach(System.out::println);
    }
}
