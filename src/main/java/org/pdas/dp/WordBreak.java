package org.pdas.dp;

public class WordBreak {
    /*
    * Given a String s and a list of words, we have to find out if we break s into any formation, where we have that word present in the dictionary
    *
    * */

    private static boolean wordBreak(String s, String[] dict){
        if (s == null || dict == null || dict.length == 0 || s.length() == 0) return false;

        int sLen = s.length();

        boolean[] dp = new boolean[sLen+1];
        dp[sLen] = true;

        for (int i = sLen-1; i >= 0 ; i--) {
            for (String word: dict){
                int wordLen = word.length();

                if (i + wordLen <= sLen && s.substring(i, i+wordLen).equalsIgnoreCase(word)){

                    String subS = s.substring(i, i+wordLen);
                    System.out.println("Found: "+subS);

                    dp[i] = dp[i+wordLen];
                }
                if (dp[i] == true){
                    break;
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String s = "neetcode";
        String[] wordDict = {"neet", "leet", "code"};

        System.out.println(wordBreak(s, wordDict));
    }
}
