package org.pdas.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneUnidirectedGraph {
    class UnidirectedGraph{
        int label;
        List<UnidirectedGraph> neighbors;
        UnidirectedGraph(int label){
            label = label;
            neighbors = new ArrayList<UnidirectedGraph>();
        }
    }

    public UnidirectedGraph clone(UnidirectedGraph node){
        if(node == null){
            return null;
        }
        Map<UnidirectedGraph, UnidirectedGraph> visited = new HashMap<>();
        return dfs(node, visited);
    }

    public UnidirectedGraph dfs(UnidirectedGraph node, Map<UnidirectedGraph, UnidirectedGraph> visited) {
        if (visited.containsKey(node)){
            return visited.get(node);
        }

        UnidirectedGraph clone = new UnidirectedGraph(node.label);
        for (UnidirectedGraph neighbor: node.neighbors){
            clone.neighbors.add(dfs(neighbor, visited));
        }
        return clone;
    }
}
