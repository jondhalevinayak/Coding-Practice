package com.local.coding_practice.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomII {

    public static void main(String[] args) {
        int[][] arr = {{1, 20}, {19, 30}, {40, 60}};

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 1;

        for(int[] itv : arr){
            if(pq.isEmpty()){
                pq.add(itv[1]);
            } else {
                if(!pq.isEmpty() && pq.peek() > itv[0]){
                    pq.poll();
                    count++;
                }
                pq.add(itv[1]);
            }
        }

        System.out.println(count);
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
