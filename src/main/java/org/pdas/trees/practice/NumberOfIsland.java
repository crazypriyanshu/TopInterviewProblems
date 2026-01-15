package org.pdas.trees.practice;

import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfIsland {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    /*
    * Given an m * n 2D binary grid . grid which
    * represents a map of '1's (land) and '0's (water), return the total number of islands.
    * */

    public static int numberOfIsland(int[][] grid){
        // step 1: scan the grid and try to find a `1` which represents island,
        // from here we can do dfs in all directions and make them 0 marking as visited
        int numberOfIsland = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1){
                    numberOfIsland++;
                    dfs(grid, row, col);
                }
            }
        }
        return numberOfIsland;

    }

    // problem : Find size of largest island
    private static int maxAreaOfIsland(int[][] grid){
        int maxArea = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1){
                    maxArea = Math.max(maxArea, dfsToFindAreaOfIsland(grid, row, col));
                }
            }
        }
        return maxArea;
    }

    private static int dfsToFindAreaOfIsland(int[][] grid, int row, int col){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0){
            return 0;
        }

        // mark this node visited
        grid[row][col] = 0;
        int area = 1;
//        return 1 + dfsToFindAreaOfIsland(grid, row+1, col) + dfsToFindAreaOfIsland(grid, row-1, col)
//                + dfsToFindAreaOfIsland(grid, row, col+1) + dfsToFindAreaOfIsland(grid, row, col-1);
        for (int[] dir: DIRECTIONS){
            area += dfsToFindAreaOfIsland(grid, row+dir[0], col+dir[1]);
        }
        return area;
    }

    public static void dfs(int[][] grid, int row, int col){
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length){
            return;
        }
        if (grid[row][col] == 0){
            return;
        }
        grid[row][col] = 0; // marking as visited
        dfs(grid, row+1, col);
        dfs(grid, row-1, col);
        dfs(grid, row, col+1);
        dfs(grid, row, col-1);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0},
                {1, 1, 0},
                {0, 1, 0},
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 1},
                {1, 1, 1}};
        // System.out.println(numberOfIsland(grid));
        // System.out.println(maxAreaOfIsland(grid));
        System.out.println(maxAreaUsingBFS(grid));
    }

    // area of maxIsland using BFS, because BFS can work for large grid sizes

    private static int maxAreaUsingBFS(int[][] grid){
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1){
                    maxArea = Math.max(maxArea, bfsToFindMaxArea(grid, row, col));
                }
            }

        }
        return maxArea;
    }

    private static int bfsToFindMaxArea(int[][] grid, int row, int col){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {row, col});
        grid[row][col] = 0;
        int area = 0;

        while (!queue.isEmpty()){
            int[] cell = queue.poll();
            area++;
            for (int[] dir: DIRECTIONS){
                int newRow = cell[0]+dir[0];
                int newCol = cell[1]+dir[1];

                if (newRow >= 0 && newRow < grid.length && newCol < grid[0].length && newCol >= 0 && grid[newRow][newCol] == 1){
                    grid[newRow][newCol] = 0;
                    queue.offer(new int[] {newRow, newCol});
                }
            }
        }
        return area;
    }
}
