package org.pdas.dp;

import java.util.Arrays;

public class NDigitNumber {
    /*
    * Find out the number of A digit positive numbers, whose digits on being added equals to a given number B.
    * Note that a valid number starts from digits 1-9 except the number 0 itself. i.e. leading zeroes are not allowed.
    * Since the answer can be large, output answer modulo 1000000007
    *
    * Approach : numberOfDigits and targetSum
    * lets say numberOfDigits = 2 and targetSum = 19 , can we reach 19 , with 2 digits number sum we will never be able to reach 19
    * at max we can reach till 18 - (9+9)
    * Also, we can have a recursive method to calculate the count and a boolean to understand if its 1st digit
    * Eg - numberOfDigits = 2, targetSum = 4
    * */

    private static final int MOD = 1000000007;
    private static int[][] memo;

    public static int findAns(int numberOfDigits, int targetSum){
        // step 1 create a 2d array to store the states
        memo = new int[numberOfDigits+1][targetSum+1];
        // fill the memo with -1

        for (int i = 0; i < numberOfDigits; i++) {
            Arrays.fill(memo[i], -1);
        }

        if(numberOfDigits < 0 || targetSum < 1 || targetSum > 9*numberOfDigits) return 0;
        return countWays(numberOfDigits, targetSum, true);


    }

    private static int countWays(int numberOfDigits, int targetSum, boolean isFirstDigit){
        if (targetSum < 0){
            return 0;
        }
        if (numberOfDigits == 0){
            return targetSum == 0 ? 1 : 0;
        }



        if (memo[numberOfDigits][targetSum] != -1 && !isFirstDigit){
            return memo[numberOfDigits][targetSum];
        }

        long count = 0;
        int startIndex = isFirstDigit ? 1 : 0;

        for (int d = startIndex; d <= 9 ; d++) {
            count = (count + countWays(numberOfDigits-1, targetSum-d, false))%MOD;
        }
        if (!isFirstDigit){
            memo[numberOfDigits][targetSum] = (int) count;
        }

        return (int) count;
    }

    public static void main(String[] args) {
        int A = 2000;
        int B = 17800;
        long startTime = System.currentTimeMillis();
        System.out.println(findAns(A, B));
        System.out.println("Time taken "+(System.currentTimeMillis() - startTime) + " ms");
    }
}
