package org.pdas.arrays.binarySearch;

public class KokoEatingBanana {
    /*
    * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
    * The guards have gone and will come back in h hours.
    * Koko can decide her bananas-per-hour eating speed of k.
    * Each hour, she chooses some pile of bananas and eats k bananas from that pile.
    * If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
    * Return the minimum integer k such that she can eat all the bananas within h hours.
    * */

    /*
    * Solution approach: we have to find the minimum eating speed -k that allows koko eating all bananas in h ours
    * If the k is too small, it will take many hours, if k is too big - it will take less hours than h
    * */


    private static int minEatingSpeed(int[] piles, int hour){
        // min speed = 1 koko can eat min of 1 banana in an hour
        // max speed would be largest in the piles array
        int left = 1;
        int right = 0;
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(piles[i], right);
        }

        int ans = right;
        while (left <= right){
            int mid = left + (right - left)/2;
            int hours = 0;
            for (int banana: piles){
                // imagine hours = 3 and banana = 10, it will take 4 hours to finish 10 banana
                hours += (hours+mid-1)/mid;
            }

            if (hours <= hour){
                ans = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {30,11,23,4,20};
        int B = 5;
        System.out.println(minEatingSpeed(A, B));

    }
}
