package org.pdas.matrix;

public class NumberOfIslands {
    // given a 2d matrix where if 1 - its a land and if its 0 its water, find number of islands

    public static int numOfIsland(Character[][] matrix) {
        // to handle null of empty grid
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    islands++;
                    traverseIsland(matrix, i, j);
                }
            }
        }
        return islands;
    }

    public static void traverseIsland(Character[][] matrix, int row, int col) {
        // when we traverse meaning we move around matrix and if we find any more '1' , we assume that as island
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == '0') {
            return;
        }
        // Setting this land as visisted, hence making it 0
        matrix[row][col] = '0';
        traverseIsland(matrix, row, col + 1);
        traverseIsland(matrix, row, col - 1);
        traverseIsland(matrix, row + 1, col);
        traverseIsland(matrix, row - 1, col);

        // if we want to move diagonally
        traverseIsland(matrix, row - 1, col + 1); // diagonally top right cell
        traverseIsland(matrix, row - 1, col - 1); // diagonally top left cell
        traverseIsland(matrix, row + 1, col - 1); // diagonally bottom left cell
        traverseIsland(matrix, row + 1, col + 1); // diagonally bottom right cell

    }

    public static void main(String[] args) {
        Character[][] arr = {
                {'1', '0', '1'},
                {'1', '1', '0'},
                {'0', '0', '1'}
        };

        System.out.println(numOfIsland(arr));


    }
}