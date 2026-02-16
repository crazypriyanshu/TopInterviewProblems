package org.pdas.popularInterview;

public class FindFirstMissingInteger {
    /*
    * Given an unsorted integer array, find the first missing positive integer
    * we should do in O(n) TC and use constant space
    * */

//    private static int findFirstMissingInteger(int[] arr){
//        if (arr == null) return -1;
//
//        int n = arr.length;
//
//        // removing noise - remove negative or zeros with N+1
//        for (int i = 0; i < n; i++) {
//            if (arr[i] < 0){
//                arr[i] = n+1;
//            }
//        }
//
//        // use the index as a hash key
//        for (int i = 0; i < n; i++) {
//            int val = Math.abs(arr[i]);
//            if (val <= n){
//
//            }
//
//        }
//    }


    /*
    * When we want to find the Cycle Sort pattern to achieve O(n) time O(1)
    * since we are looking for first missing integer , then answer must lie between (1 - n+1)
    * we would use the array itself as a hash table moving every number 'x' to its correct position at index 'x-1' if
    * */
    private static int findMissingFirst(int[] arr){
        if (arr == null) return 0;
        int n = arr.length;


        // Cycle Sort -
        // number 'x' should be at position 'x-1'
        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i]-1] != arr[i]){
                // swap arr[i] with arr[arr[i]-1]
                int correctIndex = arr[i]-1;
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            }
        }

        // find the first index that doesn't match its value
        for (int i =0; i< n; i++){
            if (arr[i] != i+1){
                return i+1;
            }
        }
        return n+1;


    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4};
        System.out.println(findMissingFirst(arr));
    }
}
