package com.local.coding_practice.PriorityQueue;

import java.util.*;

public class TopKFreqElements {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = topKFrequent(arr, k);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int n : map.keySet()) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll();
        }

        return result;
    }
}
