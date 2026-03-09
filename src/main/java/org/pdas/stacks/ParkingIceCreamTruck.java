package org.pdas.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParkingIceCreamTruck {
    /**
     * You are given a 1-D array representing the number of probable customers in that area
     * We are also given a window B, within which you can sell the ice cream - you can take the max value in that window
     * Return an output array which would have the max amount of Profit we can get
     * */
    private static int[] maxProfitForParkingTruck(int[] customers, int window){
        if (customers == null || customers.length < window) return new int[0];
        int n = customers.length;
        int[] result = new int[n-window+1];
        int resultIndex = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // remove elements if its not in the current window
            while (!dq.isEmpty() && dq.peekFirst() < i-window){
                dq.pollFirst();
            }
            // remove all elements from dq if the current index > than last all elements as they never can be max
            while (!dq.isEmpty() && customers[dq.peekLast()] < customers[i]){
                dq.pollLast();
            }
            // after checking above conditions add this to queue
            dq.offer(i);

            // once the window is reached update the result array with the peek of the stack
            if (i >= window-1){
                result[resultIndex++] = customers[dq.peekFirst()];
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
        int B = 3;
        var s = maxProfitForParkingTruck(A, B);
        for (int i: s){
            System.out.println(i);
        }
    }
}
