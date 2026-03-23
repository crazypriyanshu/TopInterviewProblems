package org.pdas.matrix;

public class FindMaxArea {

    /**
     * Given a matrix of m * n , you have to find the square area of 1's and return the max area
     * */
    private static int findMaxArea(int[][] matrix){
        if (matrix == null) return -1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows+1][cols+1];
        int maxLen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == 1){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen*maxLen;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 0},{1, 1, 1, 0}, {1, 1, 1, 0}, {1, 1, 1, 1}};
        System.out.println(findMaxArea(matrix));

    }
}
