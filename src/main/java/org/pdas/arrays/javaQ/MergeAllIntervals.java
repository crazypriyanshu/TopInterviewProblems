package org.pdas.arrays.javaQ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeAllIntervals {
    public static int[][] merge(int[][] intervals){
        int n = intervals.length;
        if (n == 1){
            return intervals;
        } else if (intervals == null) {
            return new int[0][0];
        }

        // step 1: sort the intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> results = new ArrayList<>();

        for (int i = 0; i< n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            for (int j = i+1; j <n ; j++){
                if (end >= intervals[j][0]){
                    end = Math.max(end, intervals[j][1]);
                    i=j; // skip the merged interval

                } else {
                    break;
                }
            }
            results.add(new int[] {start, end});
        }
        return results.toArray(new int[results.size()][]);
    }

    public static void main(String[] args) {
        int[][] sample = {{1, 3}, {2, 6}, {8, 10}};
        int[][] result = merge(sample);
        for (int[] values: result){
            System.out.print(values[0]+"  "+values[1]);
            System.out.println();
        }
    }
}
