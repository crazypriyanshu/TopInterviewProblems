package org.pdas.arrays.mostAskedProblems;
/**
 * Given an array A which has the list of prices of each day.
 * You have to buy 1 stock and sell once, find out the maxProfit that can be achieved
 * */
public class BuySellStock1 {

    private static int maxProfit(int[] A){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price: A){
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, (price-minPrice));
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 2, 19, 1, 8};
        System.out.println(maxProfit(arr));
    }

}
