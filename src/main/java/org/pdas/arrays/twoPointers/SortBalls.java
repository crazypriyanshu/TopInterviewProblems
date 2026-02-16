package org.pdas.arrays.twoPointers;

public class SortBalls {
    public static int[] sortColors(int[] A) {
        int size = A.length;
        int left = 0, mid = 0, right = size-1;
        while (mid <= right){
            if (A[mid] == 0){
                swap(A, left, mid);
                mid++;
                left++;
            } else if (A[mid] == 1) {
                mid++;
            } else {
                swap(A, mid, right);
                right--;

            }
        }
        return A;
    }

    private static void swap(int[] arr, int fromPosition, int toPosition){
        int temp = arr[fromPosition];
        arr[fromPosition] = arr[toPosition];
        arr[toPosition] = temp;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 1, 2, 1,1, 1, 2, 0, 0};
        System.out.println(sortColors(arr));
    }


}
