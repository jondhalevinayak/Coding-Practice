package com.local.coding_practice.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class HighFive {

    public static void main(String[] args) {
        int[][] arr = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};
        int[][] result = calHighFive(arr);
        System.out.println(Arrays.deepToString(result));
    }

    private static int[][] calHighFive(int[][] arr) {
        PriorityQueue[] s = new PriorityQueue[101];
        int n = 5;
        int size = 0;

        for(int[] item : arr){
            int i = item[0];
            int score = item[1];

            if(s[i] == null){
                size++;
                s[i] = new PriorityQueue<>(n);
            }

            s[i].offer(score);
            if(s[i].size() > n){
                s[i].poll();
            }
        }

        int[][] res = new int[size][2];

        int j = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == null){
                continue;
            }
            res[j][0] = i;
            res[j++][1] = sum(s[i])/n;
        }


        return res;
    }

    private static int sum(PriorityQueue<Integer> pq) {

        int sum = 0;
        while(!pq.isEmpty()){
            sum += pq.poll();
        }

        return sum;
    }


}
