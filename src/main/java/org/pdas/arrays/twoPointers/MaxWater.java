package org.pdas.arrays.twoPointers;

public class MaxWater {
    /**
     * You are given an integer array height.
     * Find two lines that together with the x-axis form a container,
     * such that the container contains the most water
     *
     * Area = min(h2, h1)*(width)
     * */
    private static int findMax(int[] heights){
        if (heights == null || heights.length == 0) return -1;
        int n = heights.length;
        int left = 0;
        int right = n-1;
        int maxArea = 0;

        while (left < right){
            int area = Math.min(heights[left], heights[right])*(right-left);
            maxArea = Math.max(area, maxArea);
            if (heights[left] > heights[right]){
                right--;
            }else {
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 5, 6, 7};
        System.out.println(findMax(arr));
    }
}
