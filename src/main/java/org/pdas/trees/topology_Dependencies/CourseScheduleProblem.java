package org.pdas.trees.topology_Dependencies;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleProblem {
    /*
    * We have n courses to take(0 - n-1). Some courses have prerequisites. for example
    * if we have to take course 0, you must take course 1: [0,1].
    * Problem - will we be able to finish all teh courses???
    *
    * Can we find an ordering of nodes such that every directed edge u-> v, node v becomes u, this is only possible if the graph has no cycles
    * Use of Kahn's algorithm
    * 1. Create an in-degree map- which has how many pre-requisites each course has??
    * 2. find all the courses with 0 pre-requisites and put them in a queue
    * 3. pull a course from queue(where inDegree = 0) and put them in a queue:
    *       3.1 find all the courses dependent on it
    *       3.2 decrease their in-degree by -1
    *       3.4 if dependent course in-degree is = 0 , add it again to the queue
    * 4. if all n courses are processed, there is no cycle. if we have stopped early but the queue is empty, that means there is a cycle
    *
    * Why does Kahn's algorithm work?
    * Because if we think about it if A->B->C->A, the inDegree of these nodes will never reach to zero, and they stuck in
    * */

    public  static boolean canFinish(int numOfCourses, int[][] prerequisitesList){
        // build graph and in degree array
        List<Integer>[] adjacencyList = new ArrayList[numOfCourses];
        for (int i = 0; i < numOfCourses; i++) {
            // create list for each course
            adjacencyList[i] = new ArrayList<>();
        }

        // we have to create an inDegree array which will have on position of prerequisiteCourse, we keep adding courses
        // with this we know that every index will have list of courses
        int[] inDegree = new int[numOfCourses];

        for (int[] pre : prerequisitesList){
            int course = pre[0];
            int prerequisiteCourse = pre[1];
            adjacencyList[prerequisiteCourse].add(course);
            inDegree[course]++;
        }

        // step 2 : now find all the courses with 0 prerequisite and add it to queue
        Queue<Integer> queue = new ArrayDeque<>();
        // loop through each inDegree where inDegree=0 add to queue
        for (int i=0; i < numOfCourses; i++){
            if (inDegree[i] == 0){
                // we are adding in queue all the
                queue.offer(i);
            }

        }

        // process the queue now:
        int completedCourse = 0;
        while (!queue.isEmpty()){
            // 3.1 find all the courses dependent on it
            //    *       3.2 decrease their in-degree by -1
            //    *       3.4 if dependent course in-degree is = 0 , add it again to the queue
            int currNode = queue.poll();
            completedCourse++;

            for (int neighbour: adjacencyList[currNode]){
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0){
                    queue.offer(neighbour);
                }
            }
        }

        return completedCourse == numOfCourses;
    }

    public static void main(String[] args) {
        int numOfCourses = 4;
        int[][] prerequisitesList = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        // to finish course 1 we need nothing to finish, we denote that by 0
        // to finish course 3, we need to finish course 1

        System.out.println(canFinish(numOfCourses, prerequisitesList));
    }


}
