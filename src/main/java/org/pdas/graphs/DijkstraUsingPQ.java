package org.pdas.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraUsingPQ {
    static class Pair{
        int distance;
        int node;
        Pair(int distance, int node){
            this.distance = distance;
            this.node = node;
        }
    }

    private static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adjList, int source){
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.distance- y.distance);
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        pq.add(new Pair(0, source));
        while (pq.size() != 0){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for (int i = 0; i < adjList.get(node).size(); i++) {
                int edgeWeight = adjList.get(node).get(i).get(1);
                int adjNode = adjList.get(node).get(i).get(0);

                if (dis+edgeWeight < distance[adjNode]){
                    distance[adjNode] = dis+edgeWeight;
                    pq.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adjList = new ArrayList<>();
        int V = 6;
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(new ArrayList<>(List.of(1, 4)));
        adjList.get(0).add(new ArrayList<>(List.of(2, 4)));
        adjList.get(1).add(new ArrayList<>(List.of(2, 2)));
        adjList.get(1).add(new ArrayList<>(List.of(1, 4)));

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
        var ans = dijkstra(V, adjList, source);
        for (int i: ans){
            System.out.println(i);
        }
    }
}
