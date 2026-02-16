package org.pdas.popularInterview;

import java.util.PriorityQueue;

public class TappingRainWater1 {
    /*
    * Given a non-negative integer list representing elevation map,
    * find how much water can be stored after rain
    * */

    private static int rainWaterTrap(int[] heights){
        if (heights == null || heights.length == 1) return 0;
        int n = heights.length;

        int[] rightMax = new int[n];
        int[] leftMax = new int[n];

        int totWater = 0;

        // first we calculate the leftMax for each index
        leftMax[0] = heights[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i-1], heights[i]);
        }
        // TC - O(n), space complexity O(n)

        // second we calculate the rightMax for each index
        rightMax[n-1] = heights[n-1];
        for (int i = n-2; i > 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], heights[i]);
        }
        // TC - O(n), space complexity O(n)

        for (int i = 0; i < n; i++) {
            if (heights[i] < leftMax[i] && heights[i] < rightMax[i]){
                // i can store water
                totWater += Math.min(leftMax[i], rightMax[i])- heights[i];
            }
        }
        // TC - O(n), space complexity 1

        return totWater;
        // Overall TC - O(3n), space complexity O(2n)
    }

    private static int rainWaterEfficient(int[] heights){
        if (heights == null) return 0;
        int n = heights.length;

        if (n == 1) return 0;

        int leftMax =0, rightMax = 0, leftPointer = 0, rightPointer = n-1;
        int totWater = 0;

        while (leftPointer < rightPointer){
            // step 1: try to find anything on right where water can lean upon
            if (heights[leftPointer] < heights[rightPointer]){
                if (heights[leftPointer] > leftMax){
                    leftMax = heights[leftPointer];
                } else {
                    // condition to store water
                    totWater += leftMax - heights[leftPointer];
                }
                leftPointer++;
            } else {
                if (heights[rightPointer] > rightMax) {
                    rightMax = heights[rightPointer];
                } else {
                    totWater += rightMax - heights[rightPointer];
                }
                rightPointer--;
            }
        }
        return totWater;
    }
    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3};
        System.out.println(rainWaterEfficient(heights));
    }

    /*
    * How can we tap rain water of a 2D array given heights
    * we need to have a PriorityQueue, sorted based on height,
    *
    * */

    private int trap2DRainWater(int[][] heights){
        int totCols = heights[0].length;
        int totRows = heights.length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        boolean[][] visited = new boolean[totRows][totCols];

        for (int row = 0; row < totRows; row++) {
            for (int col = 0; col < totCols; col++) {
                if (row == 0 || row == totRows-1 || col == 0 || col == totCols-1){
                    pq.offer(new int[]{row, col, heights[row][col]});
                    visited[row][col] = true;
                }
            }
        }

        int totWater = 0;

        int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()){
            int[] cell = pq.poll();
            for (int[] d: directions){
                int row = cell[0]+d[0];
                int col = cell[1]+d[1];
                // check boundary
                if (row >= 0 && row < totRows && col >= 0 && col < totCols && !visited[row][col]){
                    totWater += Math.max(0, cell[2]- heights[row][col]);
                    pq.offer(new int[] {row, col, Math.max(heights[row][col], cell[2])});
                    visited[row][col] = true;
                }
            }
        }
        return totWater;

    }
}
