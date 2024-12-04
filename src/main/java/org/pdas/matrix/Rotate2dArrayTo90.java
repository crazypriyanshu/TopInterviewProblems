package org.pdas.matrix;

import java.util.Arrays;

public class Rotate2dArrayTo90 {
    public static void transposeMatrix(Integer[][] matrix) {
        int n = matrix.length;
        for (int i=0; i < n; i++){
            for (int j=0; j<i ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void reverse(Integer[][] matrix){
        int n = matrix.length;
        for (int i =0; i< n; i++){
            int min = 0;
            int max = n-1;
            while (min < max){
                int temp = matrix[i][min];
                matrix[i][min] = matrix[i][max];
                matrix[i][max] = temp;
                min++;
                max--;
            }
        }
    }




    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2, 3},{4, 5, 6}, {7, 8, 9}};
        transposeMatrix(matrix);
        reverse(matrix);
        for (Integer[] eachRow: matrix){
            Arrays.stream(eachRow).forEach(i -> System.out.print(i +"  "));
            System.out.println();
        }
        System.out.println();

    }
}
