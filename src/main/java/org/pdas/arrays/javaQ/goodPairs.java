package org.pdas.arrays.javaQ;

import java.util.*;

public class goodPairs {
    // given an array of integers a pair (i,j) is good pair if nums[i] = nums[j] and i < j
    //[1, 2, 3]
    public static void main(String[] args) {
        HashMap<Integer, Integer> mapOfIndexes = new HashMap<>();
        int[] arr = {1, 2, 3, 1, 1, 3};
        int counter = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j=i+1; j< arr.length; j++){
                if (arr[i] == arr[j]){
                    counter++;
                    mapOfIndexes.put(i,j);
                }
            }
        }

        System.out.println(counter);

    }
}
