package org.pdas.test;

import java.util.ArrayList;

public class BackTrackEg {
    private static ArrayList<ArrayList<Integer>> calculate(ArrayList<Integer> arr){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.size();
        boolean[] visited = new boolean[n];
        long currTime = System.nanoTime();
        backtrack(arr, 0, new ArrayList<>(), res, visited);
        System.out.println("Time taken: "+((System.nanoTime() - currTime)/100)+ " ns");
        return res;

    }
    private static void backtrack(ArrayList<Integer> arr, int start, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result, boolean[] visited){
        result.add(new ArrayList<>(path));

        for (int i = start; i < arr.size(); i++) {
            visited[i] = true;
            path.add(arr.get(i));
            backtrack(arr, i+1, path, result, visited);
            visited[i] = false;
            path.remove(path.size()-1);
        }

    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(11);
        calculate(list).stream().forEach(System.out::println);


    }
}
