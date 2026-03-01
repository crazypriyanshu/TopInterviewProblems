package org.pdas.arrays.mostAskedProblems;

import java.util.*;

public class RobotCollision {
    /**
     * You are given a list @param positions[] where you have the positions of the robots
     * You are given a list @param healths[] where we have health of each robot
     * You are also given a list @param direction[] which contains the direction as "R" - Right or "L" - Left
     * Rules: if robots are going in opposite direction then only it will collide
     * if health of colliding robot is more, the stringer robot looses 1 health, but the other robot dies
     * You have to give an output array of health
     * */
    private static int[] robotCollision(int[] position, int[] health, String direction){
        int noOfRobots = position.length;
        Integer[] indices = new Integer[noOfRobots];
        for (int i = 0; i < noOfRobots; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> Integer.compare(position[a], position[b]));
        Deque<Integer> stack = new ArrayDeque<>();
        for (int currIndex: indices){
            if (direction.charAt(currIndex) == 'R'){
                stack.push(currIndex);
                continue;
            }

            while (!stack.isEmpty() && direction.charAt(stack.peek()) == 'R' && health[currIndex] > 0){
                int topIndex = stack.pop();

                if (health[currIndex] > health[topIndex]){
                    health[currIndex] -= 1;
                    health[topIndex] = 0;
                } else if (health[currIndex] < health[topIndex]) {
                    health[topIndex] -= 1;
                    health[currIndex] = 0;
                    stack.push(topIndex);
                } else {
                    health[currIndex] = 0;
                    health[topIndex] = 0;
                }
            }
        }
        return health;

    }


    public static void main(String[] args) {
        int[] positions = {3, 5, 2, 6};
        int[] health = {10, 10, 15, 12};
        String direction = "RLRL";
        var res = robotCollision(positions, health, direction);
        for (int a: res){
            System.out.println(a);
        }


    }
}
