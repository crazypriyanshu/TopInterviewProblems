package org.pdas.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Djikstra {
    private static int findMinTime(int[][] time, int startNode, int numberOfNodes){
        // Step 1 : create adjacencyList
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for(int i=1; i <= numberOfNodes; i++){
            adjacencyList.add(new ArrayList<>());
        }


        for(int[] record: time){
            int source = record[0];
            int destination = record[1];
            int weight = record[2];
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        return 1;
    }

    public static void main(String[] args) {
        int[][] B = {{1, 2, 2}, {2, 3, 3}, {3, 4, 1}, {4, 1, 4}, {1, 3, 15}};
        findMinTime(B, 1, 4);
    }
}
