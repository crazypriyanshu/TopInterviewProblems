package org.pdas.Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
// find the length of longest substring without repeating character
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s){
        char[] chars = s.toCharArray();
        int left = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < chars.length; right++) {
            char currCharacter = chars[right];
            if (map.containsKey(currCharacter)){
                //
                left = Math.max(left, map.get(currCharacter));
            }
            maxLen = Math.max(maxLen, right-left+1);
            map.put(currCharacter, right+1);
        }
        return maxLen;

    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
