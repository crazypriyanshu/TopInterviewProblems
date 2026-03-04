package org.pdas.stacks;

import org.pdas.arrays.javaQ.A;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class NextGreaterElement {
    /**
     * arr= [4, 5, 2, 10, 8]
     * */
    private static int[] nextGreaterElement(int[] input){
        int n = input.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && input[i] > input[stack.peek()]){
                int indexToUpdate = stack.pop();
                res[indexToUpdate] = input[i];
            }
            stack.push(i);
        }
        return res;
    }

    private static int[] nextGreaterElementOptimized(int[] arr){

        int n = arr.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]){
                int index = stack.pop();
                res[index] = arr[i];
            }
            stack.push(i);
        }
        return res;
    }

    private static int[] findNextSmallerElement(int[] arr){
        if (arr == null || arr.length == 0) return new int[0];
        int n = arr.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                int indexAtPeekOfStack = stack.pop();
                res[indexAtPeekOfStack] = arr[i];
            }
            stack.push(i);

        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 12, 6, 7, 8};
        var ans = findNextSmallerElement(arr);
    }
}
