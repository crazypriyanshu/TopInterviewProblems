package org.pdas.dp;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxRectangleInBinaryMatrix {

    /**
     * Given a 2-D binary matrix A of size N x M filled with 0's and 1's,
     * find the largest rectangle containing only ones and return its area.
     *
     * */
    private static int findLargestRectangle(int[][] arr){
        // convert the original matrix into prefixSum of 1's
        int rows = arr.length;
        int cols = arr[0].length;
        int maxArea = 0;

        int[] heights = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 1){
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangle(heights));

        }

        return maxArea;
    }

    private static int largestRectangle(int[] heights){
        Deque<Integer> st = new ArrayDeque<>();
        int max = 0;
        int n = heights.length;

        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0: heights[i];
            while (!st.isEmpty() && currHeight <= heights[st.peek()] ){
                int height = heights[st.pop()];
                int width = st.isEmpty() ? i : i-st.peek()-1;
                max = Math.max(max, height*width);
            }
            if(i < n) st.offer(i);
        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        System.out.println((Runtime.getRuntime().maxMemory())/1024*1000);
//        System.out.println((Runtime.getRuntime().freeMemory())/1024*1000);
//        System.out.println(Runtime.getRuntime().totalMemory()/1024*1000);
        int[][] arr = {{1, 1}, {1, 1}};
        System.out.println(findLargestRectangle(arr));
    }
}
