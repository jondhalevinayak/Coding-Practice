package com.local.coding_practice.map;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection(nums1, nums2);
        Arrays.stream(result).forEach(i -> System.out.println(i));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            set2.add(i);
        }

        if (set1.size() < set2.size()) {
            return intersection(set1, set2);
        } else {
            return intersection(set2, set1);
        }
    }

    public static int[] intersection(Set<Integer> set1, Set<Integer> set2) {
        int[] result = new int[set1.size()];
        int idx = 0;

        for (int i : set1) {
            if (set2.contains(i)) {
                result[idx++] = i;
            }
        }

        return Arrays.copyOf(result, idx);
    }
}
