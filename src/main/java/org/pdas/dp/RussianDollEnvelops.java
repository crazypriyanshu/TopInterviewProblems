package org.pdas.dp;

import java.lang.management.GarbageCollectorMXBean;
import java.util.Arrays;


public class RussianDollEnvelops {
    /*
    * Given a matrix of integers A of size N*2
    * describing dimensions of N envelop
    * A[i][0] - represents height of ith envelope
    * A[i][1] - represents width of ith envelope
    * One envelope can fit into another if height and width are greater than another envelope
    * find max number of envelope we can put inside
    *
    * Eg. A = [ [5, 4] [6, 4] [6, 7] [2, 3]]
    * */

    private static int countNumberOfEnvelopes(int[][] A){
        if (A.length == 0 || A[0].length == 0) return 0;
        int n = A.length;

        // sort A
        Arrays.sort(A, (a,b) -> {
            if(a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });

        System.out.println(Arrays.deepToString(A));

        int[] tails = new int[n];
        int size = 0;

        for (int[] env: A){
            int width = env[1];
            int left =0, right = n;
            while (left != right){
                int mid = (left+right)/2;
                if (tails[mid] < width) left = mid+1;
                else right = mid;
            }
            tails[left] = width;
            if (left == size) size++;

        }
        return size;
    }



    public static void main(String[] args) {
        int[][] arr = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        System.out.println(countNumberOfEnvelopes(arr));


    }
}
