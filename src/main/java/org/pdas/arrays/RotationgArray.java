package org.pdas.arrays;

public class RotationgArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 1, 2};
        // findRotationPoint(arr);
        int[] more = {4, 5, 6, 7, 0, 1, 2};
        findRotationPointUsingBinarySearch(more);




    }

    private static int findRotationPoint(int[] arr){
        if (arr.length == 0) return 0;
        if (arr == null) return -1;

        // 3, 4, 5, 6, 1, 2
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]){
                return i;
            }
        }
        return -1;
    }

    public static int findRotationPointUsingBinarySearch(int[] arr){
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length-1;
        // this means arr is not at all rotated
        if (arr[left] <= arr[right]) return 0;
        while (left < right){
            int mid = left + (right - left)/2;
            if (arr[mid] > arr[right]){
                // the rotation must be at right half
                left = mid+1;
            } else if (arr[mid] < arr[right]) {
                // the rotation must be in left half or even left
                right = mid-1;
            } else {
                return mid;
            }

        }
        // when left == right, we have found the point
        return left;
    }

}
