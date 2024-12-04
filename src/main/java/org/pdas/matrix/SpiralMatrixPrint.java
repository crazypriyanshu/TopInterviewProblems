package org.pdas.matrix;

public class SpiralMatrixPrint {
    public static void printSpiralMatrix(Integer[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        int rightWall = n-1, leftWall=0, topWall=0, bottomWall = m-1;
        while(topWall <= bottomWall && leftWall <= rightWall){
            for (int i= leftWall; i <= rightWall; ++i){
                System.out.print(matrix[topWall][i] + " => ");
            }
            topWall++;
            for (int i =topWall; i <= bottomWall; ++i ){
                System.out.print(matrix[i][rightWall]+ " => ");
            }
            rightWall--;

            for (int i= rightWall; i >= leftWall; --i){
                System.out.print(matrix[bottomWall][i]+ " => ");
            }
            bottomWall--;

            for (int i =bottomWall; i >= topWall; --i){
                System.out.print(matrix[i][leftWall] + " => ");
            }
            leftWall++;
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2, 3, 0, 0},{4, 5, 6, 0, 0}, {7, 8, 9, 0, 0}};
        printSpiralMatrix(matrix);
    }
}
