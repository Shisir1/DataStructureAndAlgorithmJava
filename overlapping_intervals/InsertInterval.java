package org.example.overlapping_intervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval){

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        //add all intervals before the new intervals
        while (i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        //Merge overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        //add all intervals after the new interval
        while (i < n){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1,3},{6,9}};
        int[] newInterval1 = {2,5};

        System.out.println(Arrays.deepToString(insert(intervals1,newInterval1)));

        int[][] intervals2 = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInverval2 = {4,8};

        System.out.println(Arrays.deepToString(insert(intervals2,newInverval2)));

    }
}
