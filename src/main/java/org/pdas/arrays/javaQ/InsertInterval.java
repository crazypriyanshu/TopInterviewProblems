package org.pdas.arrays.javaQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

    // we have to merge target into the intervals array
    public static int[][] mergeTargetInterval(int[][] intervals, int[] target){
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int i =0;
        int n = intervals.length;
        int startMarker =0;
        int endMarker=0;
        //
        while ( i< n && intervals[i][1] < target[0]){
            result.add(intervals[i]);
            i++;
        }
        // merging condition
        while ( i < n && intervals[i][0] <= target[1]){
            target[0] = Math.min(target[0], intervals[i][0]);
            target[1] = Math.max(target[1], intervals[i][1]);
            i++;
            result.add(target);
        }
        while (i < n){
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[n][]);
    }
    public static void main(String[] args) {
        //[[1,2],[3,5],[6,7],[8,10],[12,16]]
        int[][] arr = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12,16}};
        int[] target = {4, 8};
        System.out.println(mergeTargetInterval(arr, target));


    }
}
