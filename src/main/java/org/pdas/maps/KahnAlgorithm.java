package org.pdas.maps;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class KahnAlgorithm {
    /**
     * There are N number of courses and our target is: we have to finish 0-N-1 courses
     * To finish a course we have to finish it's pre-requisites which is given in form of a 2D array
     * prereq[ [ai, bi]] - means to finish course ai, you have to finish course bi
     * Return true, if all courses can be completed, else false.
     * */
    private static boolean canFinishCourses(int[][] preRequisites, int totalCourses){
        // create a map
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= totalCourses; i++) {
            map.put(i, 0);
        }

        for (int[] pair: preRequisites){
            int intendedCourse = pair[0];
            int preReqCourse = pair[1];
            if (map.containsKey(preReqCourse)){
                map.put(preReqCourse, map.get(preReqCourse)+1);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int course: map.keySet()){
            if (map.get(course) == 0){
                queue.offer(course);
            }
        }


        int completed = 0;
        while (!queue.isEmpty()){
            int currCourse = queue.poll();
            completed++;
            for (int[] pair : preRequisites){
                int intendedCourse = pair[0];
                int preReqCourse = pair[1];
                if (currCourse == intendedCourse){
                    map.put(preReqCourse, map.get(preReqCourse)-1);

                    if (map.get(preReqCourse) == 0){
                        queue.offer(preReqCourse);
                    }
                }
            }
        }

        return completed == totalCourses;

    }

    public static void main(String[] args) {
        int[][] preReq = {{1,2}, {2,3}, {4,3}, {3,5}};
        int totCourse = 5;
        System.out.println(canFinishCourses(preReq, totCourse));
    }
}
