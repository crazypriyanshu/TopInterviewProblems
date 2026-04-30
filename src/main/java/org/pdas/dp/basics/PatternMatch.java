package org.pdas.dp.basics;

public class PatternMatch {
    /**
     * Given 2 String A and B. B has some wildcard chars
     * ' . ' : Matches any single character.
     * ' * ' : Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     * Problem : find if B matches A
     * Approach: we take a dp 2d-array
     * dp[i][j] - is true: represents i characters of stringA, matches j chars of stringB
     * */
    private static boolean isMatching(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true; // represents that empty text can match empty pattern

        for (int j = 2; j <= n; j++) {
            if (pattern.charAt(j-1) == '*' && dp[0][j-2]){
                dp[0][j] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++){
                char textChar = text.charAt(i-1);
                char patternChar = pattern.charAt(j-1);
                if (patternChar == '.' || textChar == patternChar){
                    // if curr char matches, take the result from diagonal
                    dp[i][j] = dp[i-1][j-1];
                } else if (patternChar == '*') {
                    // if we find a * means :
                    // 1. * matches with zero of preceding element
                    // 2. * matches one or more if preceding char matches current chars

                    // zero occurrence
                    dp[i][j] = dp[i][j-2];

                    char prevPattern = pattern.charAt(j-2);
                    if (prevPattern == '.' || prevPattern == textChar){
                        dp[i][j] = dp[i][j] || dp[i-1][j];
                    }
                }
            }

        }
        return dp[n][m];


    }

    public static void main(String[] args) {
        String A = "aab";
        String B = "c*a*b";
        isMatching(A, B);
    }
}
