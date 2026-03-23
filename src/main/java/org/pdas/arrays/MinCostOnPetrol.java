package org.pdas.arrays;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinCostOnPetrol {
    /**
     * A person goes to office on bike and consumes 1 Litre of petrol everyday.
     * We have list of petrol prices of N days and given B which denotes the bike's capacity
     * Find the min cost it would take for him
     * */
    private static int findMinCost(int[] prices, int capacity){
        int n = prices.length;
        Deque<Integer> q = new ArrayDeque<>();
        int totCost = 0;

        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && q.peekFirst() < i-capacity){
                q.pollFirst();
            }

            while (!q.isEmpty() && prices[q.peekLast()] >= prices[i]){
                q.pollLast();
            }

            q.offer(i);

            totCost += prices[q.peekFirst()];
        }

        return totCost;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 4, 2, 1};
        int B = 2;
        System.out.println(findMinCost(arr, B));
    }
}
