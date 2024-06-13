package com.local.coding_practice.Graph;

import java.util.*;

public class CheapestFlightPath {
    public static void main(String[] args) {
        //int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int[][] flights = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        int k = 1;
        int src = 0;
        int dest = 3;
        int n = 4;
        int cost = findCheapestPrice(n, flights, src, dest, k);
        System.out.println(cost);
    }

    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Pair> q = new LinkedList<>();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        List<List<Pair>> adj = new ArrayList<>();
        q.add(new Pair(src, 0));

        for (int i = 0; i < flights.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] arr : flights) {
            adj.get(arr[0]).add(new Pair(arr[1], arr[2]));
        }

        while (!q.isEmpty() && k-- >= 0) {
            int size = q.size();
            while (size-- > 0) {
                Pair x = q.remove();
                for (Pair i : adj.get(x.p)) {
                    int cost = i.d;
                    int index = i.p;
                    if (cost + x.d < dp[index]) {
                        dp[index] = cost + x.d;
                        q.add(new Pair(index, dp[index]));
                    }
                }
            }
        }

        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }

    static class Pair {
        int p;
        int d;

        Pair(int p, int d) {
            this.p = p;
            this.d = d;
        }
    }
}
