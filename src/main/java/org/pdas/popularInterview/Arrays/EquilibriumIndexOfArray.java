package org.pdas.popularInterview.Arrays;

import java.util.ArrayList;
import java.util.List;

public class EquilibriumIndexOfArray {
    /*
    * You are given an array A of integers of size N. Your task is to find the equilibrium index of the given array
    * The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
    * If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
    *
    * Eg: A = [-7, 1, 5, 2, -4, 3, 0]
    * ans = 3
    *
    * Approach :
    * We know : totSum = leftSum + A[i] + rightSum;
    *           rightSum = totSum - leftSum - A[i]
    *           IF(rightSum == leftSum) we found the equilibrium index
    * */

    private static int findEquilibriumOfArray(ArrayList<Integer> arr){
        if(arr == null || arr.isEmpty()) return -1;
        int n = arr.size();

        // step 1: find totSum
        long totSum = 0;
        for(int num: arr){
            totSum += num;
        }

        long leftSum = 0;

        // now try to find index where leftSum == rightSum
        for (int i = 0; i < n; i++) {
            long rightSum = totSum - leftSum - arr.get(i);
            if (rightSum == leftSum){
                return i;
            }
            leftSum += arr.get(i);
        }

        return -1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(List.of(-7, 1, 5, 2, -4, 3, 0));
        System.out.println(findEquilibriumOfArray(arrayList));
    }
}
