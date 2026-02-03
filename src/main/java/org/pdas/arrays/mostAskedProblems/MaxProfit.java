package org.pdas.arrays.mostAskedProblems;

public class MaxProfit {
    /*
    * You want to maximize your profit by choosing a single day to buy one stock and
    * choosing a different day in the future to sell that stock.
    *   Goal: Return the maximum profit you can achieve.
    *   Constraint: If you cannot achieve any profit, return 0.
    *
    * Eg. prices = [7, 1, 5, 3, 6, 4]
    * max profit = buy on day 2 and sell on day 5, max profit = 6-1=5
    * */

    public static int maxProfit1(int[] prices){
        if (prices == null){
            return 0;
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price: prices){
            if (price < minPrice){
                minPrice = price;
            } else if (price-minPrice > maxProfit){
                maxProfit = price-minPrice;
            }
        }

        return maxProfit;
    }

    // in this use case, we can sell and buy stocks as many number of times as possible
    private static int buyStocks(int[] prices){
        if (prices == null || prices.length < 1){
            return 0;
        }
        int totalProfit = 0;
        for (int i =1; i < prices.length; i++){
            if (prices[i] > prices[i-1]){
                totalProfit += (prices[i] - prices[i-1]);
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] list = {7, 1, 5, 3, 6, 4};
        int[] p = {1, 2, 10};
        // System.out.println(maxProfit1(list));
        System.out.println(buyStocks(p));
    }
}
