package org.pdas.popularInterview.Arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    /*
    * Given an unsorted array A of size N, find the longest set of consecutive elements from A.
    * */

    private int longestConsecutiveInteger(int[] A){
        if (A == null || A.length == 0) return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num: A){
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num: A){
            if (!numSet.contains(num-1)){
                int currNum = num;
                int currentStreak = 1;

                while (numSet.contains(currNum+1)){
                    currNum+= 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }

        return longestStreak;
    }
}
