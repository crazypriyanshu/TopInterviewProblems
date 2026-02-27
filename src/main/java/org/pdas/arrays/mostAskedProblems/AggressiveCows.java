package org.pdas.arrays.mostAskedProblems;

import java.util.Arrays;
import java.util.Map;

public class AggressiveCows {
    /**
     * @param stalls: An array A of integers representing the coordinates of stalls along a straight line.
     * @param cows: An integer representing the number of aggressive cows we need to place in these stalls.
     * Rules:
     *            * Places all cows such that no 2 cows are placed in the same stall
     *            * cows can fight each other if they are placed too close
     *            * we want to keep the distance as far as possible
     *
     * Assign the cows to the stalls such that the minimum distance between any two of them is as large as possible.
     *            Return this largest minimum distance.
     *
     *
     *
     * */
    private static int arrangeCowsToStalls(int[] stalls, int cows){
        if (cows > stalls.length) return -1;

        Arrays.sort(stalls);
        // we will try to find the sweet spot between the co-ordinates given
        // min distance would be 1 and max distance would be stalls[n-1]-stalls[0]
        int n = stalls.length;
        int low = 1;
        int high = stalls[n-1]-stalls[0];
        int ans = 0;

        while (low <= high){
            int mid = low + (high-low)/2;
            if(isFeasible(stalls, cows, mid)){
                // means we can place the cows, we will look for higher limit
                low = mid +1;
                ans = mid;
            } else {
                // means this is way high
                high = mid-1;
            }
        }
        return ans;

    }

    private static boolean isFeasible(int[] stalls, int cows, int limit) {
        int count = 1;
        int lastPosition = stalls[0];

        for (int i=1; i < stalls.length; i++){
            // if curr cow is at greater distance from the last position
            if (stalls[i]-lastPosition >= limit){
                count++; // place a new cow
                // place the cow in this position
                lastPosition = stalls[i];
            }
            if (count >= cows) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 5, 9};
        int cows = 3;
        System.out.println(arrangeCowsToStalls(A, cows));

    }
}
