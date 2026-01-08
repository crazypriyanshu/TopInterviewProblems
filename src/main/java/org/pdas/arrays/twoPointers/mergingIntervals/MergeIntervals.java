package org.pdas.arrays.twoPointers.mergingIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    /*
    * You have been given a array of time intervals, you need to merge if any interval overlaps
    * */

    private static int[][] mergeIntervals(int[][] intervals){
        // i get a list of intervals, i sort it with start time and then i merge it if current.end > next.start
        Arrays.sort(intervals, ((a,b) -> Integer.compare(a[0], b[0])));
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (current[1] > next[0]){
                current[1] = Math.max(current[1], next[1]);
            } else {
                result.add(current);
                current = next;
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }

//    private static int[][] insertInterval(int[][] intervals, int[] intervalSlot){
//        // idea is to merge these intervals and assumption is already the intervals are good(no need to merge them)
//        int i = 0;
//        int n = intervals.length;
//        List<int[]> result = new ArrayList<>();
//
//        // add everything before the interval slot
//        while (i < n && intervals[i][1] < intervalSlot[0]){
//            result.add(intervals[i]);
//            i++;
//        }
//
//
//
//    }

    public static void main(String[] args) {
        // Here input is like startTime and EndTime of each interval so {1, 3} means - startTime=1 and endTime=3
        int[][] intervals = {{12, 15},{1, 2}, {3, 4}, {7, 10}};
        int[] slot = {4,6};
        // insertInterval(intervals, slot);
        // first the idea is to sort these intervals based on the start time
        mergeIntervals(intervals);


    }
}
