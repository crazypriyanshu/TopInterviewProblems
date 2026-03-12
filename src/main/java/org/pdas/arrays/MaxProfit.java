package org.pdas.arrays;

public class MaxProfit {
    private static int maxProfit(int[] prices){
        if (prices == null) return 0;
        int n = prices.length;
        int curr = prices[0];
        int maxP = 0;
        int min = 0;

        for (int price: prices){
            min = Math.min(min, price);
            maxP = Math.max(price- min, maxP);
        }
        return maxP;
    }
}
