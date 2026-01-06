package org.pdas.arrays.javaQ;

import java.util.Arrays;

public class Problem3Sum {

    public static int solve3Sum(int[] A, int B){
        Arrays.sort(A); // to get the directional control
        long closestSum = (long) A[0] + A[1] + A[2];
        for (int i= 0; i < A.length; i++){
            int left = i+1;
            int right = A.length -1;

            while (left < right){
                int currentSum = A[left] + A[i] + A[right];

                if (currentSum == B) return currentSum;

                if (Math.abs((long) B - currentSum) < Math.abs((long) B - closestSum)){
                    closestSum = currentSum;
                }
                if (currentSum < B) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return (int) closestSum;
    }
    public static void main(String[] args) {
        // Given an array A of N integers, find three integers in A such that the sum is closest to a given number B.
        // Return the sum of those three integers.
        //Assume that there will only be one solution.

        int[] A = new int[]{3, 2, 1, 7, 5};
        int B = 9;
        System.out.println(solve3Sum(A, B));



    }
}
