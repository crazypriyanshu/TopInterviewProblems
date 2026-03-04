package org.pdas.arrays.binarySearch;

import java.util.Arrays;
import java.util.OptionalInt;

public class FindMinInRotatedSorted {
    /**
     * Find the pivot point of rotated array
     * arr[] - {10, 9, 8, 7, 1,2}
     * {7, 1, 2, 3, 4, 5}
     * */
    private static void findPivotPoint(int[] arr){
        if (arr == null) return ;


        int left = 0, right = arr.length-1;

        while (left <= right){
            int mid = left + (right - left)/2;
            // check in left side
            if (arr[left] > arr[mid]){
                System.out.println("left part is not sorted from "+left+ " : "+mid);
                right = mid-1;
                if (arr[mid-1] > arr[mid]){
                    System.out.println("Mid is: "+mid);
                    break;
                }


            }else {
                System.out.println("right part is not sorted from "+(mid+1) + " : "+right);
                left = mid+1;
                if (arr[mid] > arr[mid+1] && mid < right){
                    System.out.println("Mid is : : : "+(mid+1));
                    break;
                }
            }

    }
    }

    private static int findThePivot(int[] arr){
        if (arr == null) return -1;
        int left = 0, right = arr.length-1;
        while (left < right){
            int mid = left + (right-left)/2;

            if (mid < right && arr[mid] > arr[mid+1]){
                return mid+1;
            }
            if (mid > left && arr[mid] < arr[mid-1]){
                return mid;
            }

            if (arr[left] >= arr[mid]){
                //left side is unsorted
                right = mid-1;
            } else {
                // right side is unsorted
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 6, 7, 8, 9, 10, 0, 1, 2};
        int[] B = {4, 0 , 1, 2, 3};
        int[] C = {1, 2, 3, 4, 5};
        System.out.println(findThePivot(A));
    }
}
