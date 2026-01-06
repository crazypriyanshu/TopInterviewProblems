package org.pdas.arrays.javaQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SuperArray {
    /*
    * you are given an integer array A of length n and integer array B of length m.
    * first find out super array of A, a super array is defined as the sorted array
    * obtained after merging all the possible subarrays of A.
    * You have to find and return an array C of length M where C[i] is the value of B-ith index in the super array of A.
    * If B[i] is not a valid index of the super array of A, C[i] = -1
    * */

    public static void main(String[] args) {
        SuperArray superArray = new SuperArray();
        int[] A = {1, 3, 2};
        long[] B = {0, 2, 5};
        int[] result = superArray.superArray(A, B);
        System.out.println(Arrays.toString(result));

    }

    public int[] superArray(int[] A, long[] B){
        // step1 : generate all elements from subarray and store them in a list
        ArrayList<Integer> mergedList = new ArrayList<>();
        int n = A.length;
        // generate all the sub arrays and add them to mergedList

        for(int start = 0; start < n; start++){
            int currentSum = 0;
            for (int end = start; end < n; end++){
                currentSum += A[end];
                mergedList.add(currentSum);
            }
        }
        // step 2 : sort
        Collections.sort(mergedList);
        // convert  arrayList to array
        int[] superArray = mergedList.stream().mapToInt(i -> i).toArray();

        // step 3: constructiong the superarray
        int m = B.length;
        int[] C = new int[m];

        for (int i=0; i < m; i++){
            long index = B[i];
            if (index >= 0 && index < superArray.length){
                C[i] = superArray[(int) index];

            } else{
                C[i] = -1;
            }
        }
        return C;
    }

}
