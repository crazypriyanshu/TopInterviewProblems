package org.pdas.popularInterview.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickFromBothSides {
    /*
    * You are given an integer array A of size N.
    * You have to perform B operations. In one operation, you can remove either the leftmost or the rightmost element of the array A.
    * Find and return the maximum possible sum of the B elements that were removed after the B operations.
    * */

    private static int maxPossibleSumRemovingFromBothEnds(ArrayList<Integer> A, int B){
        // approach : find the totalSum of first B elements and then try to swap it
        if (A == null) return 0;
        int n = A.size();
        int currSum = 0;

        for (int i = 0; i < B; i++) {
            currSum += A.get(i);
        }

        int maxSum = currSum;
        int left = B-1;
        int right = n-1;
        while (left >= 0){
            currSum -= A.get(left);
            currSum += A.get(right);
            maxSum = Math.max(currSum, maxSum);
            left--;
            right--;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(List.of( 2, 3, -1, 4, 2, 1 ));
        int B = 4;
        System.out.println(maxPossibleSumRemovingFromBothEnds(arrayList, B));
    }
}
