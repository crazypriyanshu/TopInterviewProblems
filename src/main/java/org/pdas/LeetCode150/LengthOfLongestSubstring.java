package org.pdas.LeetCode150;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {
    /*
    * Problem 2 : Given a string s, find the length of the longest substring without duplicate characters.
    * Eg. s = "abcabcbb" Output : 3
    * The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
    * Approach : To solve this we need to return
    *   1. Longest Substring
    *   2. Without repeating characters
    * */

    public static int lengthOfLongestSubstring(String s) {
        // Longest String needs to be a subString and without repeating characters
        Integer left = 0;
        Integer max_length = 0;
        Set<Character> characterSet = new HashSet<>();
        Integer len = s.length();
        Integer currentLength;

        for(int right = 0; right < len; right++){
            if (!characterSet.contains(s.charAt(right))){
                characterSet.add(s.charAt(right));
                currentLength = right-left+1;
                max_length = Math.max(currentLength, max_length);
            } else {
                characterSet.remove(s.charAt(left));
                left++;
            }
        }
        return max_length;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
