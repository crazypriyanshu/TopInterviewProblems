package org.pdas.popularInterview.StackProblems;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    // implement
    /*
    * You have been given arrayList, you have to tell at each index, which is the greater element
    * Use of monotonic stack
    * */

    private static int[] nge(int[] input){
        if (input == null || input.length == 0) return new int[]{};
        int n = input.length;
        int[] ngeList = new int[n];
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && input[i] > input[stack.peek()]){
                int indexToUpdate = stack.pop();
                ngeList[indexToUpdate] = input[indexToUpdate];
            }
            stack.push(i);
        }
        return ngeList;
    }

    public static void main(String[] args) {
        int[] arr = {4, 12, 5, 3, 1, 2, 5, 3, 1, 2, 4, 6};
        Arrays.stream(nge(arr)).forEach((i) -> System.out.print(" - "+i));
        System.out.println();

    }
}
