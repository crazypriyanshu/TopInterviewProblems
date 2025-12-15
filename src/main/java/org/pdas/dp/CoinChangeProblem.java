package org.pdas.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoinChangeProblem {
    // given a list of coins, find min number of coins required to reach a given amount
    // STep 1: create a dp array - dp[i] represents min no. of coins needed to reach target amount i
    // set dp[0] = 0, since no coins are needed to make amount 0 and initialize all other as amount+1- meaning non rechable
    //Strp 2: Fill the dp array
    // if the coin value is less than the current amount

    public static void coinsToReachAmount(List<Integer> coinsList, int givenAmount){
        List<List<Integer>> dp = new ArrayList<>();
//        if (givenAmount < 0) return -1;
//        if (givenAmount == 0) return 0;

        int max = givenAmount +1;
        int[] dpArray = new int[givenAmount+1];
        Arrays.fill(dpArray, max);
        dpArray[0] = 0;
        for (int i = 0; i <= givenAmount; i++){
            for (int c: coinsList){
                // can we use this coin ?
                if(c < i){
                    int remainingAmount ;
                }
            }
        }

    }
}
