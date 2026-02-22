package org.pdas.popularInterview;

import java.util.Stack;

public class FindCelebrity {
    /*
    * Given n*n matrix which has celebrity relation matrix
    * meaning if(matrix[0][2] == 1) meaning 0 knows 2 => 2 can't be a celebrity
    * if(matrix[1][2] == 0) means 1 don't know 2
    * */

    private static int findCelebrity(int[][] relationshipMatrix){

        if (relationshipMatrix == null || relationshipMatrix.length == 0 ) return 0;
        int n = relationshipMatrix.length;
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (relationshipMatrix[candidate][i] == 1){
                // meaning candidate knows someone, hence change the candidate to 1
                candidate = i;
            }
        }

        // verify:
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (relationshipMatrix[candidate][i] == 1 || relationshipMatrix[i][candidate] == 0){
                return -1;
            }
        }
        return candidate;

    }

    private static int findCelebrityEfficient(int[][] matrix){
        if (matrix == null || matrix.length == 0) return -1;
        int n = matrix.length;
        Stack<Integer> stack = new Stack<>();
        // push everything to stack
        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        // try to remove those candidates who are not a velebrity
        while (stack.size() > 1){
            int candidateA = stack.pop();
            int candidateB = stack.pop();

            if (matrix[candidateA][candidateB] == 1){
                // candidateA can't be celebrity
                stack.push(candidateB);
            } else {
                // candidateB can't be celebrity
                stack.push(candidateA);
            }

            // at the end only one should be left
        }
        int candidate = stack.pop();
        for (int i = 0; i < n; i++) {
            // verify again before declaring him the right candidate
            if (i != candidate && matrix[candidate][i] == 1 && matrix[i][candidate] == 0){
                return -1;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[][] celebrityMatrix = {{0, 1, 1, 0, 1}, {0, 0, 0, 0, 0}, {0, 1, 0, 0, 0}, {1, 1, 0, 0, 1}, {1, 1, 0, 1, 1}};
        // System.out.println("Celebrity is at index: "+findCelebrity(celebrityMatrix));
        System.out.println(findCelebrityEfficient(celebrityMatrix));

    }
}
