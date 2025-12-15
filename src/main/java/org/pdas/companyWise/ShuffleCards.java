package org.pdas.companyWise;

import java.util.Random;

public class ShuffleCards {
    public static void main(String[] args) {
        int[] arr = new int[5];
        for (int i =0; i< arr.length; i++){
            arr[i] = i;
        }
        for (int i: arr){
            System.out.println(arr[i]);
        }
        System.out.println();
        shuffleArray(arr);
        for (int i: arr){
            System.out.println(arr[i]);
        }

    }

    public static void shuffleArray(int[] arr){
        int n = arr.length;
        Random rand = new Random();
        for (int i = n-1; i > 0; i--){
            int y = rand.nextInt(i+1);
            // now replace
            int temp = arr[i];
            arr[i] = arr[y];
            arr[y] = temp;
        }
    }
}
