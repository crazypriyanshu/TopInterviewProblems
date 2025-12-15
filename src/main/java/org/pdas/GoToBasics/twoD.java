package org.pdas.GoToBasics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class twoD {
    // You are given a 2D integer matrix A, make all the elements in a row or column zero if the A[i][j] = 0.
    // Specifically, make entire ith row and jth column zero
    public static void makeRowColZero(int[][] matrix){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    map.put(i,j);
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            int row = entry.getKey();
            int col = entry.getValue();
            for (int i = row; i < matrix.length; i++) {
                for (int j = col; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
                map.remove(entry.getKey());

            }
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < 4; i++) {


        }
    }
}
