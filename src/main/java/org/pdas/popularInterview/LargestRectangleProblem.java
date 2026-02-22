//package org.pdas.popularInterview;
//
//import java.util.Stack;
//
//public class LargestRectangleProblem {
//    /*
//    * Given an array of integer - heights[] - which contains the height of building
//    * Width of each building is 1. Find the area of the largest rectangle
//    * */
//
//    private int largestRectangle(int[] heights){
//        if (heights == null || heights.length == 0) return 0;
//
//        int n = heights.length;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        int maxArea = 0;
//
//        for (int i = 0; i < n; i++) {
//            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
//                int height = heights[stack.pop()];
//                int width = i - stack.peek() -1;
//            }
//
//        }
//    }
//}
