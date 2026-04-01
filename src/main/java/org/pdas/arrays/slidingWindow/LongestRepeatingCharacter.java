package org.pdas.arrays.slidingWindow;

public class LongestRepeatingCharacter {
    /**
     * You are given a string s and an integer k.
     * You can choose any character of the string and change it to any other uppercase English character.
     * You can perform this operation at most k times.
     * Return the length of the longest substring containing the same letter
     * you can get after performing the above operations.
     * */
    private static int longestRepeatingChar(String s, int k){
        if (s == null || s.length() == 0) return -1;
        int n = s.length();
        if (n <= k) return n;
        int[] counts = new int[26];
        s = s.toUpperCase();

        int left = 0, maxFreq = 0, maxLen = 0;
        for (int right = 0; right < n; right++) {
            int currCharIndex = s.charAt(right) - 'A';
            counts[currCharIndex]++;
            maxFreq = Math.max(maxFreq, counts[currCharIndex]);
            while ((right-left+1) - maxFreq > k){
                counts[s.charAt(left)-'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, (right-left+1));
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "PPPRANSHU";
        int k = 3;
        System.out.println(longestRepeatingChar(s, k));
    }
}
