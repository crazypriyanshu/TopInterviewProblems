package org.pdas.popularInterview.Arrays;

import java.util.ArrayList;
import java.util.Comparator;

public class MergingIntervals {
    static class Interval{
        int start;
        int end;
        Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.isEmpty()) {result.add(newInterval); return result;}
        intervals.sort((a,b) -> (a.start - b.start));
        int n = intervals.size();
        int i =0;
        while (i < n && intervals.get(i).end > newInterval.start){
            result.add(intervals.get(i));
            i++;
        }
        while (i < n && intervals.get(i).start <= newInterval.end){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        result.add(newInterval);
        while (i < n){
            result.add(intervals.get(i));
            i++;
        }
        return result;

    }

    public static void main(String[] args) {

    }
}
