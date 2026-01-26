package org.pdas.graphs;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticulationPoint {
    /*
    * Articulation Point: is a node that, if removed, increases the number of connected components in the graph
    *
    * How to find ?
    * 1. using dfs calculate 2 things at each back track
    *   discovery[u] - The time at which node `u` was first visited during DFS.
    *   lowest[u] - The lowest discovery Time reachable from `u` (including itself) using back edges in a tree
    *
    * How do we decide if a point is an articulation point:
    * 1. Case 1: Root rule: If `u` is root of dfs and has at lease 2 children in the dfs tree
    * 2. Case 2: Child rule: If `u` is not the root and has a child `v` such that no node in subtree rooted at `v` has a back-edge to u or any ancestors of u
    * Mathematically - low[v] >= discovery[u]
    * */

    private static int time = 0;

    public static void findAp(int V, List<Integer>[] adj){
        int[] discovery = new int[V];
        int[] lowest = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] isAp = new boolean[V];

        Arrays.fill(discovery, -1);
        Arrays.fill(parent, -1);

        for (int i=0; i < V; i++){
            if (!visited[i]){
                dfs(i, adj, discovery, lowest, parent, visited, isAp);
            }
        }

        for (int i = 0; i < V; i++) {
            if (isAp[i]) System.out.println("Articulation point "+i);
        }
    }

    private static void dfs(int u, List<Integer>[] adj, int[] discovery, int[] lowest, int[] parent, boolean[] visited, boolean[] isAp){
        int children = 0;
        visited[u] = true;
        discovery[u] = lowest[u] = ++time;
        List<Integer> processing = adj[u];

        for (int v: adj[u]){
            if (!visited[v]){
                children++;
                parent[v] = u;
                dfs(v, adj, discovery, lowest, parent, visited, isAp);
                lowest[u] = Math.min(lowest[u], lowest[v]);

                if (parent[u] != -1 && lowest[v] >= discovery[u]){
                    isAp[u] = true;
                }
            } else if (v != parent[u]){
                lowest[u] = Math.min(lowest[u], discovery[v]);
            }

        }
        if (parent[u] == -1 && children > 1){
            isAp[u] = true;
        }
    }

    public static void main(String[] args) {
        int V = 7;
        List<Integer>[] adj = new ArrayList[V];
        for (int i=0; i < V; i++){
            adj[i] = new ArrayList<>();
        }
        adj[0].add(1);
        adj[1].add(0);

        adj[0].add(2);
        adj[2].add(0);

        adj[0].add(3);
        adj[3].add(0);

        adj[2].add(3);
        adj[3].add(2);


        adj[2].add(4);
        adj[4].add(2);

        adj[4].add(6);
        adj[6].add(4);

        adj[6].add(5);
        adj[5].add(6);

        adj[5].add(2);
        adj[2].add(5);

        findAp(V, adj);

    }
}
