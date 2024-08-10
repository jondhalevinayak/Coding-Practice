package com.local.coding_practice.Graph.ConnCompInUndirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class Graph1 {

    int V;
    ArrayList<ArrayList<Integer>> adj;

    public Graph1(int V) {
        this.V = V;
        adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(i, new ArrayList<>());
        }
    }

    void addEdge(int src, int dest) {
        adj.get(src).add(dest);
        adj.get(dest).add(src);
    }

    void connectedComponents() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSUtil(i, visited);
                System.out.println();
            }
        }
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int x : adj.get(v)) {
            if (!visited[x]) {
                DFSUtil(x, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph1 g1 = new Graph1(5);
        g1.addEdge(1, 0);
        g1.addEdge(2, 1);
        g1.addEdge(3, 4);
        System.out.println("Following are connected components");
        g1.connectedComponents();
    }


}
