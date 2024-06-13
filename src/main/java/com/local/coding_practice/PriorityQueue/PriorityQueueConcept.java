package com.local.coding_practice.PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueConcept {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        List<Integer> list = Arrays.asList(5, 4, 2, 1);
        pq.addAll(list);
        System.out.println(pq.peek());
        System.out.println("=====================");
        pq.forEach(System.out::println);
        System.out.println("=====================");
        pq.stream().sorted(Comparator.comparingInt(a->a)).forEach(System.out::println);
    }
}
