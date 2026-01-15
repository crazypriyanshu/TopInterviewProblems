package org.pdas.trees.practice;

import java.util.Arrays;

public class FloodFill {
    // given a 2D array, a starting pixel (row, col) and a newColor.
    // we need to change the color of starting pixel
    // and all pixels 4-directionally connected to it that share same original color

    private static int[][] floodFill(int[][] image, int sRow, int sCol, int newColor){
        int originalColor = image[sRow][sCol];
        if (originalColor != newColor){
            dfs(image, sRow, sCol, originalColor, newColor);
        }
        return image;
    }
    private static void dfs(int[][] image, int row, int col, int oldColor, int newColor){
        // when going out of boundary
        if (row < 0 || col < 0 || row >= image.length || col >= image[0].length){
            return;
        }
        if (image[row][col] != oldColor){
            return;
        }
        image[row][col] = newColor;
        dfs(image, row+1, col, oldColor, newColor);
        dfs(image, row-1, col, oldColor, newColor);
        dfs(image, row, col+1, oldColor, newColor);
        dfs(image, row, col-1, oldColor, newColor);
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        Arrays.stream(floodFill(image, 1, 1, 2)).map(i -> Arrays.toString(i)).forEach(System.out::println);
    }
}
