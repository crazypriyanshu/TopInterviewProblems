package org.pdas.sets;

import java.util.HashSet;
import java.util.Set;

public class UseCase1 {
    // Problem is to find the length of longest consecutive sequence in an array

    public static int findLengthOfLongestConsecutiveSubArray(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : arr){
            set.add(num);
        }
        int max = 0;
        for (int num: set){
            if (!set.contains(num-1)){
                int currNum = 0;
                int currLength = 0;
                while (!set.contains(num+1)){
                    currNum += 1;
                    currLength += 1;
                }
                max = Math.max(max, currLength);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 3, 4, 5, 6, 12};
        System.out.println(findLengthOfLongestConsecutiveSubArray(arr));

    }
}
