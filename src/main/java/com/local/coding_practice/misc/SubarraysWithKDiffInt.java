package com.local.coding_practice.misc;

import java.util.*;

public class SubarraysWithKDiffInt {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        int k = 2;
        int i = subarraysWithKDistinct(arr, k);
        System.out.println(i);
    }


    public static int subarraysWithKDistinct(int[] nums, int k) {
        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }

    private static int atMostKDistinct(int[] nums, int k) {
        int count = 0;
        int left = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            int num = nums[right];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);

            while (frequencyMap.size() > k) {
                int leftNum = nums[left++];
                frequencyMap.put(leftNum, frequencyMap.get(leftNum) - 1);
                if (frequencyMap.get(leftNum) == 0) {
                    frequencyMap.remove(leftNum);
                }
            }

            count += right - left + 1;
        }

        return count;
    }



}
