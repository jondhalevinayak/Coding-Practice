package com.local.coding_practice.PriorityQueue;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        KthLargestElement kthLargestElement = new KthLargestElement(3, new int[]{4, 5, 6});
        System.out.println(kthLargestElement.add(7));
    }

    public int k;
    public PriorityQueue<Integer> pq;

    public KthLargestElement(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add(i);

            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.add(val);

        if (pq.size() > k) {
            pq.poll();
        }

        return !pq.isEmpty() ? pq.peek() : 0;
    }
}
