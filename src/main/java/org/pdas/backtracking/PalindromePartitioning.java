package org.pdas.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    /*
    * Input: s = "aab"
    * Goal: Split the string into all possible parts where every part is a palindrome.
    * Output: [["a", "a", "b"], ["aa", "b"]]
    * */

    private static List<List<String>> palindromePartitioning(String s){
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;

    }
    private static void backtrack(String s, int start, List<String> path, List<List<String>> res){
        // base case:
        if (start== s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < s.length() ; i++) {
            // the main logic
            if(isPalindrome(s, start, i)){
                path.add(s.substring(start, i+1));
                backtrack(s, i+1, path, res);
                path.remove(path.size()-1);
            }

        }
    }

    private static boolean isPalindrome(String s, int startIndex, int currIndex){
        int left = startIndex;
        int right = currIndex;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abaaa";
        palindromePartitioning(s).stream().forEach(System.out::println);
    }
}
