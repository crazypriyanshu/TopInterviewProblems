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

    public static void main(String[] args) {
        int[] A = {3, 4, 2};
        Arrays.stream(codingMentor(A)).forEach(System.out::println);
    }
}
