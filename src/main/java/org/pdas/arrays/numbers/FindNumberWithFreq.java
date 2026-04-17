package org.pdas.arrays.numbers;

import java.util.HashMap;
import java.util.Map;

public class FindNumberWithFreq {
    /**
     *  Given an array, print all the elements whose frequency is one, that is
     * they do not have duplicates. Example: Array = [-1, -2, 3, 3, -2] Output = -1
     * */
    private static void printUnique(int[] arr){
        if (arr == null) return;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int number=0;
        boolean found = false;
        for (int num: arr){
            if (map.get(num) == 1){
                found = true;
                number = num;
                break;
            }
        }

        if (!found){
            System.out.println("No numbers");
        } else {
            System.out.println("Number: "+number);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 2, 3, 4, 4, 6, 1, 3};
        printUnique(arr);
    }
}
