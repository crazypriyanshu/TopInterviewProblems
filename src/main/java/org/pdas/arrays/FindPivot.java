package org.pdas.arrays;

public class FindPivot {
    // you have been given an array which is sorted but is rotated once, find the pivot element
    // [4, 5, 6, 1, 2, 3] - ans - 6
    private static int findPivot(int[] arr){
        int left = 0;
        int right = arr.length-1;

        while (left <= right){
            int mid = left + (right - left)/2;

            // case 1 : if mid is the pivot
            // 4, 5, 6, 1, 2, 3
            if (mid < right && arr[mid] > arr[mid+1]) return mid;
            // case 2 : if mid-1 is the pivot
            if (mid > left && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            // decide which part to check
            if (arr[left] >= arr[mid]){
                right = mid-1;
            } else {
                left = mid+1;
            }

        }
        return -1;

    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        System.out.println(findPivot(arr));
    }
}
