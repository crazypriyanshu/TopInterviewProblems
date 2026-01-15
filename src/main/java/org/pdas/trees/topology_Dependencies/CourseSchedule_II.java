package org.pdas.trees.topology_Dependencies;

import java.util.*;

public class CourseSchedule_II {
    /*
    *
    * Similar question: parallel courses, this time we have to return the actual order of courses
    * if cycle exists return an empty array
    *
    * Eg : n = 4, prerequisite = [[1, 0], [2, 0], [3, 1], [3, 2]]
    * output: [0, 1, 2, 3] or [0, 2, 1, 3]
    * */

    public static int[] orderOfCourses(int n, int[][] relationship){
        int[] inDegree = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] relation: relationship){
            int prevCourse = relation[1];
            int nextCourse = relation[0];
            adjList.get(prevCourse).add(nextCourse); // direction: prev -> next
            inDegree[nextCourse]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int[] result = new int[n];
        int index = 0;

        while (!queue.isEmpty()){
            int current = queue.poll();
            result[index++] = current;
            for (int neighbor: adjList.get(current)){
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        return index == n ? result: new int[0];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] relationship = new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        Arrays.stream(orderOfCourses(n, relationship)).forEach(System.out::println);
    }
}
