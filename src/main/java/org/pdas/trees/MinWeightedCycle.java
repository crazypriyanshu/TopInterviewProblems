package org.pdas.trees;

import java.util.*;

public class MinWeightedCycle {
    static class Edge{
        int to, weight;
        Edge(int to, int weight){
            this.to=to;
            this.weight = weight;
        }
    }
    /**
     * Given an integer V, representing number of vertices in a graph.
     * Also you are given a matrix of integers of size N x 3 where N represents number of Edges in a Graph and Triplet (B[i][0], B[i][1], B[i][2])
     * implies there is an undirected edge between B[i][0] and B[i][1] and weight of that edge is B[i][2].
     * Find and return the weight of minimum weighted cycle and if there is no cycle return -1 instead.
     * NOTE: Graph may contain self loops but does not have duplicate edges.
     * */
    public static int findMinWeightedCycle(int V, int[][] matrix){
        int minCycle = Integer.MAX_VALUE;
        Map<Integer, List<Edge>> adjList = new HashMap<>();

        // create a adjacency list in a map where each node has List of edges it can connect to
        for (int[] edge: matrix){
            adjList.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(new Edge(edge[1], edge[2]));
            adjList.computeIfAbsent(edge[1], k-> new ArrayList<>()).add(new Edge(edge[0], edge[2]));
        }
        for(int[] edge: matrix){
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            int d = dijkstra(u, v, adjList, weight, V);
            if (d != Integer.MAX_VALUE){
                minCycle = Math.min(minCycle, d + weight);
            }
        }
        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;

    }

    private static int dijkstra(int start, int target, Map<Integer, List<Edge>> adjList, int origWeight, int V){
        PriorityQueue<int[]> pq =  new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> distances = new HashMap<>();
        pq.offer(new int[]{start, 0});
        distances.put(start, 0);

        while (!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int w = curr[1];
            if (u == target) return w;
            if (w > distances.getOrDefault(u, Integer.MAX_VALUE)) continue;
            for (Edge e: adjList.getOrDefault(u, new ArrayList<>())){
                // ignore direct edge, we are testing for cycle
                if (
                        (u == start && e.to == target && e.weight == origWeight) || (u == target && e.to == start && e.weight == origWeight)
                ) continue;

                // update the min weight
                if (w + e.weight < distances.getOrDefault(e.to, Integer.MAX_VALUE)) {
                    distances.put(e.to, w + e.weight);
                    pq.add(new int[]{e.to, w + e.weight});
                }
            }

        }
        return Integer.MAX_VALUE;

    }

    public static void main(String[] args) {
        int V = 4;
        int[][] matrix = {{1, 2, 2}, {2, 3, 3}, {3, 4, 1}, {4, 1, 4}, {1, 3, 15}};
        findMinWeightedCycle(V, matrix);
    }
}
