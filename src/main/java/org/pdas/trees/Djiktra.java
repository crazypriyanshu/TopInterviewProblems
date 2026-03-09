package org.pdas.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Djiktra {
    /**
     * @param V int - Total number f vertices
     * @param adjList - Given for every vertex - ways to reach and their cost
     * @param source - Starting nodeNumber
     * @return distance - Distance array which would tell the min distance to reach to that vertex
     *
     *                Given number of vertices of a tree - int V
     *                Create a class Pair, which has nodeNumber, distance
     *                We should have a Priority Queue to store
     *                adjList - {
     *                {{1,4}, {2,4}},
     *                {{0,4}, {2,2}},
     *                {{0,4}, {1, 2}, {3,3}, {4,1}, {5,6}},
     *                {{2,3}, {5,2}},
     *                {{2,1}, {5,3}},
     *                {{3,2}, {4,5}}
     *                }
     *
     *
     * */
    static class Pair{
        int distance;
        int nodeNumber;
        Pair(int nodeNumber, int distance){
            this.distance = distance;
            this.nodeNumber = nodeNumber;
        }
    }
    private static int[] findMinDistance(int V, ArrayList<ArrayList<ArrayList<Integer>>> adjList, int source){

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(V, (a, b) -> a.distance - b.distance);
        int[] distance = new int[V];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()){
            Pair current = pq.poll();
            int nodeNumber = current.nodeNumber;
            int distanceFromNode = current.distance;
            // if
            if (distanceFromNode > distance[nodeNumber]) continue;
            for (int i=0; i < adjList.get(nodeNumber).size(); i++){
                int edgeDistance = adjList.get(nodeNumber).get(i).get(1);
                int edgeNode = adjList.get(nodeNumber).get(i).get(0);
                int newDistance = distanceFromNode+edgeDistance;
                if (newDistance < distance[edgeNode]){
                    // update the distance
                    distance[edgeNode] = newDistance;
                    pq.add(new Pair(edgeNode, distance[edgeNode]));
                }
            }
        }
        return distance;


    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<ArrayList<Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());

        }
        adjList.get(0).add(new ArrayList<>(List.of(1,4)));
        adjList.get(0).add(new ArrayList<>(List.of(2, 4)));
        adjList.get(1).add(new ArrayList<>(List.of(0, 4)));
        adjList.get(1).add(new ArrayList<>(List.of(2, 2)));
        adjList.get(2).add(new ArrayList<>(List.of(0, 4)));
        adjList.get(2).add(new ArrayList<>(List.of(1, 2)));
        adjList.get(2).add(new ArrayList<>(List.of(3, 3)));
        adjList.get(2).add(new ArrayList<>(List.of(4, 1)));
        adjList.get(2).add(new ArrayList<>(List.of(5, 6)));
        adjList.get(3).add(new ArrayList<>(List.of(2, 3)));
        adjList.get(3).add(new ArrayList<>(List.of(5, 2)));
        adjList.get(4).add(new ArrayList<>(List.of(2, 1)));
        adjList.get(4).add(new ArrayList<>(List.of(5, 3)));
        adjList.get(5).add(new ArrayList<>(List.of(3, 2)));
        adjList.get(5).add(new ArrayList<>(List.of(4, 5)));

        int source = 0;
        var v = findMinDistance(V, adjList, source);
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }

    }
}
