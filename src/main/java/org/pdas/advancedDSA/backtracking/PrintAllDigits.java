package org.pdas.advancedDSA.backtracking;

import java.util.Arrays;

/*
Backtracking is - generating all the possibilities
Problem statement :
Given N digits, print all the numbers that are formed by only digits 1 & 2.
Print all the numbers in increasing order
* */
public class PrintAllDigits {
    public static void printAllDigits(int[] arr, int index, int n){
        // base case :
        if (index == n){
            Arrays.stream(arr).forEach(e -> System.out.print(e + " _ "));
            System.out.println("");
            return;
        }
        for (int i = 0; i < 3; i++) {
            arr[i] = i;
            printAllDigits(arr, index+1, n);
        }
    }
    public static void main(String[] args) {
        int N = 3;
        int[] arr = new int[N];
        printAllDigits(arr, 0, N);


    }
}
