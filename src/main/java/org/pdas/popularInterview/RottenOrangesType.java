package org.pdas.popularInterview;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrangesType {
    int minLength = 0;

    private static int findMinTimeToInfectAll(char[][] grid){
        if (grid.length == 0 || grid == null){
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited= new boolean[rows][cols];
        int result = 0;


        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1'){
                    result = dfs(grid, row, col, visited, result);
                }
            }

        }
        return result;
    }

    private static int dfs(char[][] grid, int row, int col, boolean[][] visited, int minLength){
        if (row < 0 || row > grid.length || col < 0 || col > grid[0].length){
            return minLength;
        }
        if (visited[row][col] == true){
            return 0;
        }
        visited[row][col] = true;

        dfs(grid, row+1, col, visited, minLength+1); // go down
        dfs(grid, row-1, col, visited, minLength+1); // go up
        dfs(grid, row, col+1, visited, minLength+1); // go right
        dfs(grid, row, col-1, visited, minLength+1); // go left

        return minLength;
    }

    public static void main(String[] args) {
        char[][] grid = {{'0', '0', '0'}, {'0', '1', '0'}, {'0', '0', '0'}};
        System.out.println(minTime(grid));
        
        

    }
    
    public static int minTime(char[][] grid){
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int totalEmpty = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1'){
                    queue.offer(new int[]{row, col});
                } else {
                    totalEmpty++;
                }
            }
        }
        
        if (totalEmpty == 0) return 0;
        int minTime = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        
        while (!queue.isEmpty()){
            int size = queue.size();
            boolean spreadThisLevel = false;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] direction: directions){
                    int nRow = cell[0] + direction[0];
                    int nCol = cell[1] + direction[1];

                    if (nRow >= 0 && nCol >= 0 && nRow < rows && nCol < cols && grid[nRow][nCol] == '0'){
                        grid[nRow][nCol] = 1;
                        queue.offer(new int[]{nRow, nCol});
                        totalEmpty--;
                        spreadThisLevel = true;
                    }
                }
            }
            if (spreadThisLevel) minTime++;
        }
        return totalEmpty == 0 ? minTime: -1;
    }
}
