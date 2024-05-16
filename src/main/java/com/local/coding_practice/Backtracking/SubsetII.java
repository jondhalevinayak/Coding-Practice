package com.local.coding_practice.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetII {

    public static void main(String[] args) {

        int[] nums = {1,2,2};
        List<List<Integer>> ans = subsetsWithDup(nums);
        System.out.println(ans);

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    static void backtrack(List<List<Integer>> ans, List<Integer> subans, int[] nums, int start){
        ans.add(new ArrayList<>(subans));
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            subans.add(nums[i]);
            backtrack(ans, subans, nums, i+1);
            subans.remove(subans.size()-1);
        }
    }
}
