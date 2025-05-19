package org.pdas.stacks;

import java.util.Stack;

/*
* Problem - Given an array A, where A represents the histogram, i.e A[i] denotes the height of
* the ith histogram's bar. width of each bar is 1
* Find the area of the largest rectangle formed by histogram
* */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] A = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(A));

    }

    public static int largestRectangleArea(int[] arr) {
        int maxArea = 0;

        int[] sLeft = new int[arr.length];
        int[] sRight = new int[arr.length];
        Stack<Integer> st = new Stack<>();


        // find nearest smallest to the left
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            sLeft[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);

        }

        // find smallest to right
        st.clear();
        for (int i = arr.length-1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            sRight[i] = st.isEmpty() ? arr.length : st.peek();
            st.push(i);

        }

        // calculate max area :

        for (int i = 0; i < arr.length; i++) {
            int width = sRight[i] - sLeft[i], height = arr[i];
            maxArea = Math.max(maxArea, height* width);

        }

        return maxArea;
    }
}
