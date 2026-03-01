package org.pdas.Strings;

public class LongestPalindromicString {
    /**
     * Given a String, find the biggest palindromic subString
     * Eg. - "abcbr" Ans - bcr
     * */
    private static int longestPalindromic(String s){
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 0;
        int n = s.length();
        char[] arr = s.toCharArray();

        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i+1);
            maxLen = Math.max(maxLen, Math.max(len1, len2));
        }
        if (maxLen == s.length()) System.out.println("Pure palindrome string: "+s);
        return maxLen;


    }

    private static int expandFromCenter(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        String s = "abcba";
        System.out.println(longestPalindromic(s));
    }
}
