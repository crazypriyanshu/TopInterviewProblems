package org.pdas.trees.topology_Dependencies;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ParallelCourses {
    /*
    * Problem : we are given N courses labelled from 1 to N. We are also given the relations where
    * relation[i] = [prevCourse, nextCourse]
    * In one semester we can take any number of courses as long as we have taken all the prerequisites into account
    * Goal: Find the min number of semester needed to take all the course, if its impossible to take all courses, return -1
    *
    * In previous problem we just needed to know if we can finish , here we need to know how many steps ?
    * it will take to peel the graph. This is called the shortest path in DAG problem
    *
    * Approach:
    * int[] inDegree : to track prerequisite for each course
    * List<List<Integer>> adjList : to track the directed graph
    * Queue<Integer> queue: to hold the courses which has 0 in-degree
    *
    * Instead of counting one by one, we process the queue level by level
    * 1. initialize semesters = 0, totalTaken = 0
    * 2. While queue is not empty:
    *   2.1 Increase semester
    *   2.2 get the current size of the queue. this represents the courses that we can take simultaneously in this semester
    *   2.3 for each of those 'size' courses:
    *       2.3.1 increment totalTaken
    *       2.3.2 decrement inDegree of neighbours
    *       2.3.3 if a neighbour's inDegree becomes 0, add it to the queue
    *   2.4 after loop, if totalTaken = N, return semesters else -1
    * */

    public static int minimumSemesters(int n, int[][] relations){
        int[] inDegree = new int[n+1];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());

        }

        // build the graph
        for (int[] rel: relations){
            int prevCourse = rel[0];
            int nextCourse = rel[1];
            adjList.get(prevCourse).add(nextCourse);
            inDegree[nextCourse]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < n; i++) {
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int semesters = 0;
        int coursesTaken = 0;

        while (!queue.isEmpty()){
            int size = queue.size(); // number of courses avl for this semester
            semesters++;

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                coursesTaken++;

                for (int neighbor: adjList.get(current)){
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0){
                        queue.offer(neighbor);
                    }
                }
            }
        }

        return coursesTaken == n ? semesters : -1;
    }
}
