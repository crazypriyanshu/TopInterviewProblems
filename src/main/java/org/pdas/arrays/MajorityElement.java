package org.pdas.arrays;

public class MajorityElement {
    /*
    * Find the majority element - an element if it appears n/2 times from a given list
    *
    * Either we can store each element's frequency in a HashMap- which would take O(n) SC - which is not good where we try to fetch
    *  or we can use Boyer-Moore’s Voting Algorithm - which allows us to find the element in TC- O(n) and SC- O(1)
    *
    * Intuition - In a room full of people representing different political parties -
    * if a party has more than 50% of people, they will always have something remaining after all possible different pairs have left
    * How it works ?
    * 1. Iterate through array
    * 2. if count == 0, we pick the current element and make it candidate & increase count = 1
    * 3. if the same element appears again increase the count++
    * 4. if next element is different decrease the count - this represents the pairing
    *
    * */

    private static int mooresVotingAlgorithm(int[] arr){
        int candidate = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0){
                candidate = arr[i];
                count = 1;
            } else if (arr[i] == candidate) {
                count++;
            } else {
                count--;
            }

        }

        // Step 2 : verification
        int verificationCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == candidate){
                verificationCount++;
            }
        }

        return verificationCount > arr.length/2 ? candidate: -1;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 3, 3, 1, 3, 4, 5, 7, 3, 1};
        System.out.println(mooresVotingAlgorithm(A));


    }
}
