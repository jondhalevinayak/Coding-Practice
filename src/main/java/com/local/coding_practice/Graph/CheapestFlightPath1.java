package com.local.coding_practice.Graph;

import java.util.*;

public class CheapestFlightPath1 {
    public static void main(String[] args) {
        //int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        //int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int[][] flights = {{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}};
        //int[][] flights = {{1,0,99}};

        int k = 1;
        int src = 0;
        int dest = 3;
        int n = 4;
        int cost = findCheapestPrice(n, flights, src, dest, k);
        System.out.println(cost);
    }

    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        if (flights == null || flights.length == 0) {
            return -1;
        }

        //adj Node
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.putIfAbsent(flight[0], new HashMap<>());
            map.get(flight[0]).put(flight[1], flight[2]);
        }

        //min heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        //Queue<int[]> pq = new LinkedList<>();
        pq.add(new int[]{0, src});

        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);

        while (!pq.isEmpty() && k-- >= 0) {
            int size = pq.size();

            while (size-- > 0) {
                int[] currArr = pq.remove();
                int currNode = currArr[1];
                int currDist = currArr[0];

                if (map.containsKey(currNode)) {
                    for (int adjNode : map.get(currNode).keySet()) {
                        int adjNodeDist = map.get(currNode).get(adjNode);
                        if (currDist + adjNodeDist < dp[adjNode]) {
                            dp[adjNode] = currDist + adjNodeDist;
                            pq.add(new int[]{dp[adjNode], adjNode});
                        }
                    }
                }
            }
        }

        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];

    }

}
