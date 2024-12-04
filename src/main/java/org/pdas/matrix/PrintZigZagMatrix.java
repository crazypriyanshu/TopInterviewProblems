package org.pdas.matrix;

public class PrintZigZagMatrix {
    static void zigZagMatrix(int[][] matrix, int tot_rows, int tot_cols ){
        int row = 0, col = 0;
        boolean row_increment = false;

        // print the matrix of lower half
        int mn = Math.min(tot_rows, tot_cols);
        for (int len =1; len <= mn; len++){
            for (int i =0; i < len; ++i){
                System.out.println(matrix[row][col]);
                if (i+1 == len){
                    break;
                }
                // if row_increment is true, increment row and decrement col
                if (row_increment){
                    ++row;
                    --col;
                }else {
                    --row;
                    ++col;
                }
            }

            if (len == mn){
                break;
            }
        }
    }

    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        zigZagMatrix(matrix, 3, 3);
    }
}
