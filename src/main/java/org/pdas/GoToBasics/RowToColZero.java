package org.pdas.GoToBasics;

import java.util.Arrays;

public class RowToColZero {
    // Problem : Given a 2D A, make all the elements in that row or col 0 , if A[i][j] == 0, specifically entire ith row and entire jth row
    public static int[][] makeRowColZero(int[][] A){
        if (A == null || A.length == 0 || A[0].length == 0){
            return null;
        }
        int totalRows = A.length;
        int totalCols = A[0].length;

        boolean isRowZero = false;
        boolean isColZero = false;

        // check if 1st row needs to be zeroed
        for (int i = 0; i < totalRows; i++) {
            if (A[i][0] == 0){
                isRowZero = true;
            }
        }

        // check if first col needs to be zeroed
        for (int j = 0; j < totalCols; j++){
            if (A[0][j] == 0){
                isColZero = true;
            }
        }

        // now iterate over first row and first col
        for (int i = 1; i < totalRows; i++) {
            for (int j = 1; j < totalCols; j++) {
                if (A[i][j] == 0){
                    A[i][0] = 0; // make 1st row zero
                    A[0][j] = 0; // make 1st col col zero
                }

            }
        }

        // zero out rest of the A :
        for (int i = 1; i < totalRows; i++) {
            for (int j = 1; j < totalCols; j++) {
                if (A[i][0] == 0 || A[0][j] == 0){
                    A[i][j] = 0;
                }

            }

        }

        // zero out first row if flag was set
        if (isRowZero){
            for (int i = 0; i < totalRows; i++) {
                A[i][0] = 0;
            }
        }

        if (isColZero){
            for (int j = 0; j < totalCols; j++) {
                A[0][j] = 0;
            }
        }
        return A;
    }
    
    public static void printA(int[][] A){
        for (int[] rows: A){
            System.out.println(Arrays.toString(rows));
        }
    }

    public static void main(String[] args) {
        final int NUMBER_OF_ROWS = 0;
        final int NUMBER_OF_COLS = 0;
//        int[][] A = new int[NUMBER_OF_ROWS][NUMBER_OF_COLS];
        int[][] A1 = {
                {1, 2, 3, 0},
                {5, 0, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };
        System.out.println("--- Original A ----");
        printA(A1);
        System.out.println("--------setting Zeroing logic-----");
        makeRowColZero(A1);
        printA(A1);

        int[] A = new int[4];
        Arrays.stream(A).sum();

    }
}