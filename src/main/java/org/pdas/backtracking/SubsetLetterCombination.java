package org.pdas.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetLetterCombination {
    /*
    * Given a string containing digits from 2-9 inclusive,
    * return all possible letter combinations that the number could represent.
    * A mapping of digits to letters (just like on the telephone buttons) is given below.
    * Eg. digits = "23" Mapping: 2: [a, b, c] , 3: [d, e, f]
    * Expected output: ["ad", "ae", "af", "bd", "be", "bf", "cd", ce", "cf"]
    * */


    // the map - rules
    private static String[] mapping = {"", "abc", "def", "ghi"};
    public static List<String> letterCombinations(String digits){
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(result, new StringBuilder(), digits, 0);
        return result;

    }

    private static void backtrack(List<String> result, StringBuilder path, String digits, int index){
        // base case: if path length matches digits, we are done
        if (index == digits.length()){
            result.add(path.toString());
            return;
        }

        // explore:get letters fom current digit
        String letters = mapping[digits.charAt(index) - '0'];

        for (char c: letters.toCharArray()){
            path.append(c);
            backtrack(result, path, digits, index+1); // move to next digit
            path.deleteCharAt(path.length() -1);
        }

    }
    public static void main(String[] args) {
        String digits = "123";
        letterCombinations(digits).stream().forEach(System.out::println);

    }
}
