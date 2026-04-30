package org.pdas.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class  CoinChangeProblem {
    // given a list of coins, find min number of coins required to reach a given amount
    // STep 1: create a dp array - dp[i] represents min no. of coins needed to reach target amount i
    // set dp[0] = 0, since no coins are needed to make amount 0 and initialize all other as amount+1- meaning non rechable
    //Step 2: Fill the dp array
    // if the coin value is less than the current amount

    public static int coinsToReachAmount(int[] coinsList, int amount){
        // how do we find number of ways
        // if we take int[] dp where we can count number of ways till that amount
        // lets take dp[] of size amount+1, and initialize each position with amount +1

        // dp[i] should represent number of coins required to reach that amount
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for (int i = 1; i <= amount ; i++) {
            for (int coin: coinsList){
                // if coin is greater than amount, then only we can take it
                if (i - coin >= 0){
                    dp[i] = Math.min(dp[i], 1+dp[i-coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];


    }

    public static void main(String[] args) {
        int[] coins = {1, 3, 5};
        int amount = 8;
        System.out.println(coinsToReachAmount(coins, amount));
    }
}
