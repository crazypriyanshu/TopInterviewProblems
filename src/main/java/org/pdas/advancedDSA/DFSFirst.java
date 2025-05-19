package org.pdas.advancedDSA;

import java.util.ArrayList;

public class DFSFirst {
    /* You are given N towns and all are connected via unique directed path.
    * Given 2 towns find whether you can reach the first town from the second town without repeating any edge
    * Input - Array A of size n,
    * int - B - there exists a directed graph between A[i] to i+1 for every 1 < i < N,
    * int C
    * Find whether B is reachable from C*/
    public static void main(String[] args) {
        int[] A = {1, 1, 2};
        int B = 1;
        int C = 2;
        System.out.println(ifReachPossible(A, C, B));

    }

    public static boolean ifReachPossible(int[] inputA, int sourceC, int destinationB) {
        int n = inputA.length;
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            int source = inputA[i];
            int destination = i+1;
            graph[source].add(destination);
        }
        boolean[] visited = new boolean[n+1];
        return dFSPath(sourceC, destinationB, graph, visited);

    }

    public static boolean dFSPath(int source, int target, ArrayList<Integer>[] graph, boolean[] visited) {
        if (source == target){
            return true;
        }
        visited[source] = true;

        for (int neighbour: graph[source]){
            if (dFSPath(neighbour, target, graph, visited) && !visited[neighbour]){
                return true;
            }
        }
        return false;
    }
}
