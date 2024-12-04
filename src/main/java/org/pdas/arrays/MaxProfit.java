package org.pdas.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxProfit {
    public static Integer maxProfit(List<Integer> priceList){
        if (priceList.size() == 0 || priceList == null){
            return 0;
        }
        Integer minPrice = Integer.MAX_VALUE;
        Integer maxProfit = 0;
        for (Integer price: priceList){
            minPrice = Math.min(price, minPrice);
            maxProfit = Math.max(maxProfit, price- minPrice);
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        // given a list of price list of stocks and calculate the max profit
        // imagine that you have only permitted to complete at most one transaction
        // either to buy a stock or sell one share of tht stock
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(4);
        integerList.add(5);
        integerList.add(2);
        integerList.add(4);
        System.out.println(maxProfit(integerList));
    }
}
