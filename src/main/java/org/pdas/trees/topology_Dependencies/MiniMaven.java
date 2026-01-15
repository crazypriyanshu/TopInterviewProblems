package org.pdas.trees.topology_Dependencies;

import java.util.*;

public class MiniMaven {
    /*
    * The problem : You have been given a list of projects and each project has list of dependencies
    * */

    public static List<String> getBuildOrder(List<Project> projects){
        Map<String, List<String>> adjList = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();

        //initialize
        for (Project p: projects){
            inDegree.put(p.name, 0);
            adjList.put(p.name, new ArrayList<>());
        }

        // build the graph: on the fly
        for (Project p: projects){
            for (String dependency: p.dependencies){
                adjList.get(dependency).add(p.name);
                inDegree.put(p.name, inDegree.get(p.name)+1);
            }
        }

        Queue<String> queue = new ArrayDeque<>();
        for (String projectName: inDegree.keySet()){
            if (inDegree.get(projectName) == 0){
                queue.add(projectName);
            }
        }
        List<String> buildOrder = new ArrayList<>();
        while (!queue.isEmpty()){
            String currentProject = queue.poll();
            buildOrder.add(currentProject);

            // get the neighbours
            for (String neighbour: adjList.get(currentProject)){
                int updatedInDegree = inDegree.get(neighbour) -1;
                inDegree.put(neighbour, updatedInDegree);

                if (updatedInDegree == 0){
                    queue.offer(neighbour);
                }
            }
        }

        if (buildOrder.size() != projects.size()){
            System.out.println("Circular dependency detected");
        }

        return buildOrder;
    }
}
