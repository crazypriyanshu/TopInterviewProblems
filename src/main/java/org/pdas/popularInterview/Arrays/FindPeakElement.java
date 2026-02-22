package org.pdas.popularInterview.Arrays;

import java.util.regex.Pattern;

public class FindPeakElement {
    /*
    * Given an array of integers A, find and return peak element in it. An array element is considered peak if it is not smaller than it neighbours.
    * For corner element, we need to consider only 1 element
    * */

    public int findPeak(int[] A){
        if (A == null) return 0;
        int n = A.length;
        if (n ==1 ) return A[0];

        if (A[0] >= A[1]) return A[0];
        if (A[n-1] >= A[n-2]) return A[n-1];

        int low = 1;
        int high = n-2;
        while (low <= high){
            int mid = low + (high-low)/2;
            if (A[mid] >= A[mid-1] && A[mid] >= A[mid+1]){
                return A[mid];
            } if (A[mid+1] > A[mid]){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return -1;
    }
}
