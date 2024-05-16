package com.local.coding_practice.BinarySearch;

public class SearchInRoatedClass {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        int ans = searchTarget(nums, target);
        System.out.println(ans);
    }

    private static int searchTarget(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }

        int i = 0;
        int n = nums.length;
        for (i = 0; i < n - 2 && nums[i] < nums[i + 1]; i++) ;


        if (nums[i] == target) {
            return i;
        }

        if (target <= nums[i] && target >= nums[0]) {
            return dobinarySearch(0, i - 1, nums, target);
        } else {
            return dobinarySearch(i + 1, n - 1, nums, target);
        }
    }

    private static int dobinarySearch(int lo, int hi, int[] nums, int target) {
        if (lo > hi) {
            return -1;
        }
        int mid = (lo + hi) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        if (target < nums[mid]) {
            return dobinarySearch(lo, mid - 1, nums, target);
        }
        return dobinarySearch(mid + 1, hi, nums, target);

    }
}
