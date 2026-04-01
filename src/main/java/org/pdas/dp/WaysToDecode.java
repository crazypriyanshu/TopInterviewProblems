package org.pdas.dp;

public class WaysToDecode {
    /**
     * given char[] , calculate the number of ways to decode entire char[]
     * '1' - A, '2' - B.... '26' -Z
     * each char[i] - {0-9}
     * */
    private static int waysToDecode(String s){
        if (s == null || s.length() == 0 || s.charAt(0) == 0) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1; // empty string has 1 way to be decoded
        dp[1] = 1; //

        for (int i = 2; i <= s.length(); i++) {
            int oneDigit = s.charAt(i-1) - '0';
            if (oneDigit >= 1){
                dp[i] += dp[i-1];
            }
            int twoDigits = Integer.parseInt(s.substring(i-2, i));
            if (twoDigits >= 10 && twoDigits <= 26){
                dp[i] += dp[i-2];
            }

        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "112";
        System.out.println(waysToDecode(s));
    }
}
