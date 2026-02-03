package org.pdas.dp.digitDp;

public class MagicDigit {
    /*
    * Consider the decimal presentation of an integer. Let's call a number D - magic if digit D appears in decimal presentation of the number on all even positions and nowhere else.
    * For example, the numbers 1727374, 17, 1 are 7 - magic but 77, 7, 123, 34, 71 are not 7 - magic.
    * On the other hand the number 7 is 0 - magic, 123 is 2 - magic, 34 is 4 - magic and 71 is 1 - magic.
    * Find the number of D - magic numbers in the segment [L, R] that are multiple of C.
    * Because the answer can be very huge you should only find its value modulo 109 + 7
    * (so you should find the remainder after dividing by 109 + 7).
    * */

    static long[][][] memo; // index, remainder, is_less
    static String numberStr;
    static int D, C;
    static int MOD = 1_000_000_007;

    public static long solve(int index, int remainder, boolean isLess){
        if (index == numberStr.length()){
            return remainder == 0 ? 1 : 0;
        }

        int tight = isLess ? 1: 0;
        if (memo[index][remainder][tight] != -1){
            return memo[index][remainder][tight];
        }

        long count = 0;
        int limit = isLess ? 9 : numberStr.charAt(index)-'0';
        boolean isEvenPos = (index+1)%2 == 0;

        for (int digit = 0; digit <= limit ; digit++) {
            if (isEvenPos && digit != D) continue;
            if (isEvenPos && digit == D) continue;
            boolean nextIsLess = isLess || (digit < limit);
            int nextRem = (remainder * 10 + digit)%C;
            count = (count + solve(index+1, remainder, nextIsLess))%MOD;
        }

        return memo[index][remainder][tight] = count;
    }
}
