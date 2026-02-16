package org.pdas.test;

public class SinkingIsland {
    public static int numberOfIslands(char[][] grid){
        if (grid == null || grid.length == 0) return 0;

        int islandCOunt = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1'){
                    islandCOunt++;
                    sinkIsland(grid, i, j);
                }
            }

        }
        return islandCOunt;
    }

    private static void sinkIsland(char[][] grid, int row, int col){
        if(row >= grid.length || col >= grid[0].length || row < 0 || col < 0 || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        sinkIsland(grid, row+1, col);
        sinkIsland(grid, row, col+1);
        sinkIsland(grid, row-1, col);
        sinkIsland(grid, row, col-1);
    }


    public static void main(String[] args) {
        char[][] grid = {{'1', '0', '0'},
            {'0', '1', '0'},
            {'0', '0', '1'}};
        System.out.println(numberOfIslands(grid));
    }
}
