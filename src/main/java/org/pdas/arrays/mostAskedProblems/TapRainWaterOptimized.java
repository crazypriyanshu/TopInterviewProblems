package org.pdas.arrays.mostAskedProblems;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TapRainWaterOptimized {
    private static int tapRainWater(int[] heights){
        if (heights == null || heights.length == 0) return -1;
        if (heights.length == 1) return 0;

        int n = heights.length;
        int left = 0; int right = n-1;
        int leftMax = 0, rightMax = 0;
        int totWater = 0;
        int maxContainer = 0;
        int maxPosition = 0;

        while (left < right){
            if (heights[left] < heights[right]){
                if (heights[left] > leftMax){
                    leftMax = heights[left];
                } else {
                    if (maxContainer < leftMax-heights[left]) maxPosition = left;
                    maxContainer = Math.max(maxContainer, leftMax-heights[left]);

                    totWater += leftMax-heights[left];
                }
                left++;
            } else {
                if (heights[right] > rightMax){
                    rightMax = heights[right];
                } else {
                    if (maxContainer < rightMax-heights[right]) maxPosition = right;
                    maxContainer = Math.max(maxContainer, rightMax-heights[right]);
                    totWater += rightMax-heights[right];
                }
                right--;
            }

        }
        System.out.println(maxContainer+" at position: "+maxPosition);
        return totWater;
    }

    public static void main(String[] args) {

    }



    @Test
    public void testStandardValley(){
        int[] heights = {3, 2, 4, 1, 8, 3, 2};
        assertEquals(4, tapRainWater(heights));
    }

    @Test
    public void testNoWaterPossible(){
        assertEquals(0, tapRainWater(new int[]{1, 2, 3, 4, 5})); // Sloped up

        assertEquals(0, tapRainWater(new int[]{5, 4, 3, 2, 1})); // Sloped down
        assertEquals(0, tapRainWater(new int[]{3, 3, 3}));      // Flat
    }

}
