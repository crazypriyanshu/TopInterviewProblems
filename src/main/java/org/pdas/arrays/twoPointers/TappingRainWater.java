package org.pdas.arrays.twoPointers;

public class TappingRainWater {
    /**
     * Given an array which has length of building in a 1D array
     * Find how much water we can store
     * */
    private static int trappingRainWater(int[] heights){
        int n = heights.length;
        int start = 0, end = n-1;
        int leftMax = 0; // max height seen from left
        int rightMax = 0; // max height seen from right
        int waterStored = 0;

        while (start <= end){
            if (rightMax > leftMax){
                // we are sure we can store water in the right side
                if (leftMax < heights[start]){
                    leftMax = heights[start];
                } else {
                    waterStored += (leftMax-heights[start]);
                }
                start++;
            } else {
                if (rightMax < heights[end]){
                    rightMax = heights[end];
                } else {
                    waterStored += rightMax-heights[end];
                }
            }
        }
        return waterStored;



    }

    public static void main(String[] args) {
        int[] A = {5, 4, 1, 4, 3, 2, 7};
        System.out.println(trappingRainWater(A));
        // TC - O(n) , SC - O(1)
    }
}
