package org.pdas.arrays.mostAskedProblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class LargestRectangleInHistogram {
    /*
    * We have been give an array of heights of a histogram
    * find the max area
    * */

    private static int findMaxArea(int[] heights){
        if (heights == null) return -1;
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;

        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i- stack.peek()-1;
                maxArea = Math.max(maxArea, height*width);
            }
            stack.push(i);

        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {2, 1, 5, 6, 2, 3};
        System.out.println(findMaxArea(height));
    }
}
