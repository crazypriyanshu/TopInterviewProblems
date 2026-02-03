package org.pdas.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /*
    * Given an unsorted integer array A of size N.
    * Find the length of the longest set of consecutive elements from array A.
    *
    * */

    public static int longestConsecutiveSequence(int[] arr){
        Set<Integer> numSet = new HashSet<>();
        for (int num: arr){
            numSet.add(num);
        }

        int maxLength = 0;

        for (int num: numSet){
            if (!numSet.contains(num-1)){
                int currNum = num;
                int currLen = 1;
                while (numSet.contains(currNum+1)){
                    currLen++;
                    currNum++;
                }
                maxLength = Math.max(currLen, maxLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] A = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSequence(A));
    }
}
