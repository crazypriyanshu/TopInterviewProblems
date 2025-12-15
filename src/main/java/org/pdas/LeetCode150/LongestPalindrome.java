package org.pdas.LeetCode150;

public class LongestPalindrome {
    public static String longestPalindrome(String s){
        if(s == null || s.length() == 1){
            return s;
        }

        Integer start = 0;
        Integer end = 0;
        int even;
        int odd;

        for (int i = 0; i < s.length(); i++){
            odd = expandAroundCenter(s, i, i);
            even = expandAroundCenter(s, i, i+1);
            int max_count = Math.max(even, odd);
            if (max_count > end - start){
                start = i - (max_count - 1)/2;
                end = i + max_count/2;
            }

        }
        return s.substring(start, end);
    }

    public static int expandAroundCenter(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
