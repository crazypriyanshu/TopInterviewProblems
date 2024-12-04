package org.pdas.arrays;

import java.util.Stack;

public class NextGreaterElement {
    // for every A[i] return the first greater element on the right
    public static int[] nextGreater(int[] A){
        int n = A.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n-1; i <= 0; i--){
            while (!stack.isEmpty() && stack.peek() <= A[i]){
                stack.pop();
            }
            result[i] = stack.isEmpty()? -1 : stack.peek();
            stack.push(A[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {5, 10, 10, -1};
        int[] result = nextGreater(A);
        for (Integer i: result){
            System.out.println(i);
        }
    }
}
