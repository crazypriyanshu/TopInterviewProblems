package org.pdas.arrays.twoPointers;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] arr){
        int write = 1;
        // in this solution read is the fast pointer and write is a slow pointer
        for (int read = 1; read < arr.length; read++) {
            // read traverses through array
            if (arr[read] != arr[read-1]){
                // if you do not have any duplicate, then
                arr[write] = arr[read];
                write++; // update write only when conditions are not met, means both can expand
            }
            // read will expand every loop
        }
        return write;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3};
        System.out.println(removeDuplicates(arr));
        
    }
}
