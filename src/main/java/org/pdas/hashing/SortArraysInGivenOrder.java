package org.pdas.hashing;

import java.util.*;

public class SortArraysInGivenOrder {
    /*
    * Given two arrays of integers A and B, Sort A in such a way that the relative order among the elements will be the same as those are in B.
    * For the elements not present in B, append them at last in sorted order.
    * Return the array A after sorting from the above method.
    * NOTE: Elements of B are unique.
    * */

    public static int[] solveSortArraysInGivenOrder(int[] A, int[] B){
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num: A){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int[] res = new int[A.length];
        int index = 0;

        for (int num: B){
            if (map.containsKey(num)){
                int count = map.get(num);
                while (count > 0){
                    res[index++] = num;
                    count--;
                }
                map.remove(num);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();
            while (count > 0){
                res[index++] = num;
                count--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1, 2, 6};
        int[] B = {2, 1};
        System.out.println(solveSortArraysInGivenOrder(A, B));
    }
}
