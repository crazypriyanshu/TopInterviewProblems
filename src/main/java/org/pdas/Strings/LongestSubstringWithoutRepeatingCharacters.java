package org.pdas.Strings;

import java.util.HashSet;
import java.util.Set;
// find the length of longest substring without repeating character
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int maxLength = 0, i =0, j =0;
        while (i < s.length() && j < s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                maxLength = Math.max(maxLength, j-i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "spring";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
