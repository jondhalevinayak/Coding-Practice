package com.local.coding_practice.Array;

import java.util.HashSet;

public class LCS {

    public static void main(String[] args) {
        int[] nums = {0, -1};
        int ans  = longestConsecutive(nums);
        System.out.println(ans);
    }

    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums != null && nums.length < 2){
            return 1;
        }

        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums){
            hs.add(i);
        }

        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){

            if(!hs.contains(nums[i]-1)){
                int j  = nums[i];
                while(hs.contains(j)){
                    j++;
                }

                if(j - nums[i] > ans){
                    ans = j - nums[i];
                }
            }
        }

        return ans;

    }
}
