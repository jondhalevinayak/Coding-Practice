package com.local.coding_practice.DynamicPrograming;

public class UniquePath {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        int[][] dp = new int[m + 1][n + 1];
        int[][] dp1 = new int[m][n];
        int ans = findUniquePath(m, n, dp);
        int ans1 = findUniquePath1(m-1, n-1, dp1);
        System.out.println(ans);
        System.out.println(ans1);
    }

    private static int findUniquePath(int m, int n, int[][] dp) {
        if (m == 1 || n == 1) {
            return 1;
        }

        if (dp[m][n] != 0) {
            return dp[m][n];
        }

        int ans1 = findUniquePath(m - 1, n, dp);
        int ans2 = findUniquePath(m, n - 1, dp);
        return ans1 + ans2;
    }
    private static int findUniquePath1(int m, int n, int[][] dp) {
        if (m == 0 && n == 0) {
            return 1;
        }

        if (m < 0 || n < 0) {
            return 0;
        }

        int ans1 = findUniquePath1(m - 1, n, dp);
        int ans2 = findUniquePath1(m, n - 1, dp);
        return ans1 + ans2;
    }

}
