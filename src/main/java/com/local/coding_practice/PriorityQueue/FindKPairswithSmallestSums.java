package com.local.coding_practice.PriorityQueue;

import java.util.*;

public class FindKPairswithSmallestSums {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        int k = 2;
        List<List<Integer>> list = kSmallestPairs(nums1, nums2, k);
        list.forEach(System.out::println);
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int sum = nums1[i] + nums2[j];

                if(pq.size() < k){
                    pq.add(new int[]{nums1[i], nums2[j], sum});
                } else {
                    if(pq.peek()[2] > sum){
                        pq.poll();
                        pq.add(new int[]{nums1[i], nums2[j], sum});
                    } else {
                        break;
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        while(!pq.isEmpty()){
            List<Integer> ansList = new ArrayList<>();
            int[] pair = pq.poll();
            ansList.add(pair[0]);
            ansList.add(pair[1]);
            result.add(ansList);
        }

        return result;
    }
}
