package org.pdas.graphs;

public class DijkstraAlgo {
    /*
    * This is one of the way to find the shortest path in a graph with non negative edge weights
    *
    * In real world distance is not about steps, it's about weights between two nodes in a graph
    *
    * 1. Initialize: Set the distance to the source as 0 and all other nodes as Infinity.
    * 2. Pick the "Cheapest": Use a Min-PriorityQueue to always pick the node with the current smallest distance.
    * 3. Relax Edges: For the current node, look at all neighbors. If dist[current] + weight(current, neighbor) < dist[neighbor], you’ve found a better way! Update dist[neighbor] and push it into the PriorityQueue.
    * 4. Repeat: Do this until the PriorityQueue is empty.
    * */
}
