package org.example.overlapping_intervals;

import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals){
        if(intervals.length <=1){
            return intervals;
        }

        //sort the intervals by their start times
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals){
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart){
                //Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentEnd,nextEnd);
            } else {
                //non-overlapping intervals, add it to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals2 = {{1,4},{4,5}};

        System.out.println(Arrays.deepToString(merge(intervals1)));
        System.out.println(Arrays.deepToString(merge(intervals2)));

    }
}
