package org.pdas.arrays.strings;

public class LongestOccurringCharacter {
    /**
     * For the given string such as "aabbbbbcc" print the longest
     * occurring character,index and number of times it occurs.
     * Ex: longest occurring character is b and length is 5 at index 2.
     * */
    private static void longestOccurringChar(String s){
        if (s == null || s.length() == 0) return;
        int n = s.length();
        char maxChar = s.charAt(0);
        int maxIndex = 0;
        int maxLen = 0;

        int currIndex = 0;
        int currLen = 1;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i-1)){
                currLen++;
            } else {
                if (currLen > maxLen){
                    maxLen = currLen;
                    maxIndex = i;
                    maxIndex = currIndex;
                    maxChar = s.charAt(i-1);
                }
                currLen = 1;
                currIndex =i;
            }
        }
        if (currLen > maxLen){
            maxLen = currLen;
            maxIndex = currIndex;
            maxChar = s.charAt(s.length()-1);
        }
        System.out.println("MaxLen = "+maxLen+" maxIndex: "+maxIndex+ " maxChar: "+maxChar);
    }

    public static void main(String[] args) {
        String s = "aabbbbbcc";
        longestOccurringChar(s);
    }
}
