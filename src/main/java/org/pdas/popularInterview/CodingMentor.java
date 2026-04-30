package org.pdas.popularInterview;

import java.util.Arrays;
import java.util.Stack;

public class CodingMentor {
    /*
    * We have been given int[] which has scores of n students
    * A student can select a mentor j if j > i and A[j] > A[i]
    * return the list of mentors array, if student can choose mentor then their index or else -1
    * */

    public static int[] codingMentor(int[] marks){
        int n = marks.length;
        int[] result = new int[n];
        if (n == 0) return result;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && marks[i] > marks[stack.peek()]){
                int indexToUpdate = stack.pop();
                result[indexToUpdate] = i+1; // 1 based indexing

            }
            stack.push(i);
            
        }
        return result;
    }

    /**
     * Calculates min number of steps taken to for n to reduce to zero
     * if n is even : we can do n/2
     * if n is odd : we can either add+1 or sub-1
     * */
    private static int findMinStepsToZero(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n%2 == 0) return 1+findMinStepsToZero(n/2);
        return Math.min(1+findMinStepsToZero(n-1), 1+findMinStepsToZero(n+1));

    }

    public static void main(String[] args) {
        int[] A = {3, 4, 2};
        Arrays.stream(codingMentor(A)).forEach(System.out::println);

        System.out.println(findMinStepsToZero(10));
    }
}
