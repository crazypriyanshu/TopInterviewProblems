package org.pdas.advancedDSA.backtracking;

public class SubsetCountToSum {
    /*
    * Given an array of N elements, count the subsets having sum as k
    * */

    public static int subset(int[] arr, int index, int N, int K, int sum) {
        if (index == N){
            if (index == sum){
                return 1;
            } else {
                return 0;
            }
        }
        int count = 0;
        // if we pick
        sum = sum + arr[index];
        count = subset(arr, index+1, N, K, sum);
        // if we don't pick
        sum = sum - arr[index];
        count = subset(arr, index+1, N, K, sum);
        return count;

    }

    public static void main(String[] args) {
        int[] A = {5, 2, 7};
        int K = 7;
        System.out.println(subset(A, 0, A.length, K, 0));
    }
}
