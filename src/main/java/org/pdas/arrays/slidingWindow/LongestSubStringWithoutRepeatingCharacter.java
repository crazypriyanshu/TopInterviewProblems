package org.pdas.arrays.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacter {
    /**
     * Find the length of longest subString for a given String s, where there is no repeating character
     * */
    private static int findLongestSubString(String s){
        if (s == null || s.length() == 0) return -1;
        int n = s.length(),left = 0;
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)){
                left = Math.max(left, map.get(ch)+1);
            }
            map.put(ch, right);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
            
    }

    public static void main(String[] args) {
        String s = "TillWeGoTha";
        System.out.println(findLongestSubString(s));
    }
}
