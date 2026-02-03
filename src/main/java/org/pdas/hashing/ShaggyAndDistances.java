package org.pdas.hashing;

import java.util.HashMap;
import java.util.Map;

public class ShaggyAndDistances {
    /*
    * Shaggy has an array A consisting of N elements.
    * We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.
    * Shaggy wants you to find a special pair such that the distance between that pair is minimum.
    * Distance between two indices is defined as |i-j|.
    * If there is no special pair in the array, then return -1.
    * */


    public static int solveSpecialPair(int[] arr){
        // special pair such that distance between pair is minimum
        Map<Integer, Integer> lastSeen = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (lastSeen.containsKey(arr[i])){
                int distance = i - lastSeen.get(arr[i]);
                minDistance = Math.min(distance, minDistance);
            }
            lastSeen.put(arr[i], i);

        }

        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 3, 4, 1, 7};
        System.out.println(solveSpecialPair(arr));
    }
}
