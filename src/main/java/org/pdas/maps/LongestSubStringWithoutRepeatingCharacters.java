package org.pdas.maps;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {

    private static int findLongestSubStringLen(String s){
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < n; right++) {
            char currChar = s.charAt(right);
            if (map.containsKey(currChar)){
                left = Math.max(left, map.get(currChar)+1);
            }
            maxLen = Math.max(maxLen, right-left+1);
            map.put(currChar, right);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(findLongestSubStringLen(s));
    }
}
