package org.pdas.dp;

public class UniquePath {
    /*
    * Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
    * At any instance, if you are on (x, y), you can either go to (x, y + 1) == right or (x + 1, y) == down
    * Now consider if some obstacles are added to the grids. Return the total number unique paths from (1, 1) to (n, m).
    * An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.Given Source Point and Destination points are 1-based index.
     *Eg.  A = [[0, 0, 0]
     *          [0, 1, 0]
     *          [0, 0, 0]]
     * from pos(0,0) we can go to
    * */

    private static int uniquePath(int[][] grid){
        if (grid == null) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        if (grid[0][0] == 1 || grid[rows-1][cols-1] == 1) return 0; // if starting and ending points are blocked we have no path
        dp[0][0] = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1){
                    dp[i][j] = 0; // blocked
                    continue;
                }

                // as we can move only right or down, if we are coming from 0,0

                if (i > 0){
                    // if valid path coming from top
                    dp[i][j] += dp[i-1][j];
                }
                if (j > 0){
                    dp[i][j] += dp[i][j-1];
                }

            }
        }
        return dp[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[][] A = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        System.out.println(uniquePath(A));
    }
}
