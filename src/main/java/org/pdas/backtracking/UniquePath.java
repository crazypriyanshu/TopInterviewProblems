package org.pdas.backtracking;


import java.util.ArrayList;

public class UniquePath {
    /*
    * Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
    * At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
    * Now consider if some obstacles are added to the grids.
    * Return the total number unique paths from (1, 1) to (n, m).
    *
    * 1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
    * 2. Given Source Point and Destination points are 1-based index.
    *
    * */

    private record Point(int x, int y){}

    private static ArrayList<ArrayList<Integer>> findUniquePaths(ArrayList<ArrayList<Integer>> grid){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = grid.size(), m = grid.get(0).size();
        backtrack(grid, result, new ArrayList<>(), 1, 1);
        return result;

    }

    private static void backtrack(ArrayList<ArrayList<Integer>> grid,
                                  ArrayList<ArrayList<Integer>> result,
                                  ArrayList<Integer> path,
                                  int row, int col)
    {
        int n = grid.size();
        int m = grid.get(0).size();

        if (row == n-1 && col == m-1){
            path.add(grid.get(row).get(col));
            result.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        if (row >= n || row < 0 || col >= m || col <0 || grid.get(row).get(col) == 0){
            return;
        }

        path.add(grid.get(row).get(col));
        backtrack(grid, result, path, row, col+1);
        backtrack(grid, result, path, row+1, col);
        path.remove(path.size()-1);

    }
}
