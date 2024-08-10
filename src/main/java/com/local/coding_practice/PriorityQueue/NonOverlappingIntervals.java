package com.local.coding_practice.PriorityQueue;

import java.util.Arrays;

public class NonOverlappingIntervals {

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int ans = eraseOverlapIntervals(intervals);
        System.out.println(ans);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int n = intervals.length;
        int count = 1;
        int end = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }

        return n - count;
    }
}
