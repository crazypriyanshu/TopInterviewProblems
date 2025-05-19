package org.pdas.advancedDSA.greedy;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class ChildrenRatingCandiesProblem {
    // n children standing in a line, each child is assigned to a rating value.
    // we have to give candies to these children -> each child must have at least one candy
    // child with higher rating get more candies than its neighbour
    // find the minimum candies that can be given

    public static int distributeMinimumCandies(int[] input) {
        int[] sortedInput = Arrays.stream(input).sorted().toArray();
        int candies = 1;
        int minSum = 0;
        for (int child = 1; child <= sortedInput.length-1; child++) {
            minSum += candies;
            if (sortedInput[child] > sortedInput[child-1]) {
                candies += 1;
            }
        }
        return minSum;

    }
    public static void main(String[] args) {
        int[] A = {1, 2};
        System.out.println(distributeMinimumCandies(A));

    }
}
