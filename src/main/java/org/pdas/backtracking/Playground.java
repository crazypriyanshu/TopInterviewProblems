package org.pdas.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Playground {
    private static List<String> giveSomeIntegers(int[] choices, int n){
        List<String> res = new ArrayList<>();
        backtrack(0, n, choices, new StringBuilder(), res);
        return res;
    }

    private static void backtrack(int pos, int n, int[] choices, StringBuilder path, List<String> res){


        if (path.length() == n+1){
            res.add(path.toString());
            return;
        }

        for (int i = 0; i < choices.length; i++) {
            // start adding in path
            path.append(choices[i]);
            backtrack(pos+1, n, choices, path, res);
            path.deleteCharAt(path.length()-1);
        }
    }


    public static void main(String[] args) {
        // you have number of choices to make a number is: 1, 3, 7 - how many numbers you can create?
        // 137, 317, 713, 731,
        int[] choices = {1, 3, 7};
        int numberNeeded = 3;
        giveSomeIntegers(choices, numberNeeded).stream().forEach(System.out::println);
    }
}
