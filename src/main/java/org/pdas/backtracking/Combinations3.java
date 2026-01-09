package org.pdas.backtracking;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Combinations3 {
    // Find all possible combination of k numbers that add up to n using numbers 1 to 9
    // each number can be used only once
    // k =3 and n = 7
    // output - [[1, 2, 4]]

    public static List<List<Integer>> combinations3(int totalSum, int numberOfElements){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, totalSum, numberOfElements, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int start,int totalSum, int numberOfElements,List<Integer> path, List<List<Integer>> res ){
        // adding a valid result where we have totalSum = 0(as we keep subtracting i from totalSum in each iteration) and if numberOfElements = 0(again in each iteration we keep subtracting)
        // if both the conditions are true then it means, we have desired totalSum, with desired numberOfElement

        if (totalSum == 0 && numberOfElements == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        // invalid path
        if (totalSum < 0 || numberOfElements == 0){
            return;
        }

        // numbers
        for (int i = start; i < 10; i++) {
            if (i > totalSum){
                break;
            }

            path.add(i);
            backtrack(i+1,totalSum-i, numberOfElements-1, path, res);
            path.remove(path.size()-1);

        }
    }

    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        long start = System.currentTimeMillis();
        combinations3(n, k).stream().forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println("Time took: "+(end-start) + " ms");


        // Clarity:
        /*
        * 1. Why do we pass "start" in backtracking? - To avoid reusing numbers, to make sure combinations are built incrementally and also to prevent duplicates
        * 2. Why totalSum == 0 && numberOfElements == 0 ? exactly numberOfElements is used, and totalSum exactly = target
        * 3. Why `if (totalSum < 0 || numberOfElements == 0){ return;}` - because if totalSum < 0 means: we are going out of the total range, and further increase would only increase the sum
        * 4. What would happen totalSum > 0 && numberOfElements == 0
        *
        * Time complexity : ~= O(C(9, numberOfElements))
        * I used backtracking with parameters tracking remaining count and remaining sum.
        * At each step, I choose the next number from a strictly increasing range to avoid duplicates.
        * I prune paths when the sum becomes negative or when required elements reach zero.
        * */
    }
}


