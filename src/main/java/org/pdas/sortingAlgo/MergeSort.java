package org.pdas.sortingAlgo;

import java.util.Arrays;

public class MergeSort {
    //

    public static void mergeSort(int[] arr){
        if (arr.length <= 1) return;

        int mid = arr.length/2;
        int[] leftArray = Arrays.copyOfRange(arr, 0, mid);
        int[] rightArray = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(arr, leftArray, rightArray);

    }

    private static void merge(int[] arr, int[] leftArray, int[] rightArray){
        int i =0, j = 0, k = 0;
        while (i < leftArray.length && j < rightArray.length){
            if (leftArray[i] <= rightArray[j]){
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
        while (i < leftArray.length){
            arr[k++] = leftArray[i++];
        }
        while (j < rightArray.length){
            arr[k++] = rightArray[j++];
        }
    }


    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }



}
