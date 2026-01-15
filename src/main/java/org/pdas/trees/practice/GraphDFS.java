package org.pdas.trees.practice;

import java.util.ArrayList;
import java.util.List;

public class GraphDFS {
    // all reachable nodes, the number od nodes are labelled 0 - n-1
    // int[][] edges: A undirected list of connections
    // int startNode : nodes start travelling from(usually 0)
    // Task is to find out all the nodes that are reachable from startNode

    public List<Integer> getReachableNodes(int n, int[][] edges, int startNode){
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        // track visited nodes and results
        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();

        // kick of dfs
        dfs(startNode, adjList, visited, result);
        return result;
    }

    private static void dfs(int curr, List<List<Integer>> adjList, boolean[] visited, List<Integer> result){
        visited[curr] = true;
        result.add(curr);
        // explore
        for (int neighbor: adjList.get(curr)){
            if (!visited[neighbor]){
                dfs(neighbor, adjList, visited, result);
            }
        }
    }
}
