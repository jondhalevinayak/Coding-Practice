package com.local.coding_practice.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 20}, {40, 60}, {19, 30}};
        System.out.println(Arrays.deepToString(arr));

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        System.out.println(Arrays.deepToString(arr));
    }

}
