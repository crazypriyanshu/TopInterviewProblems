package org.pdas.popularInterview;

public class KokoBananaEatingProblem {
    // Koko a monkey -> has pile of banana heaps, represented by array piles[i] - representing each pie.
    // koko can eat certain banana at k banana per hour.
    // If it starts eating from pile she must finish that pile within hour
    public static int KokoEatingMaximumBanana(int[] piles, int k){
        int left =1, right = getMax(piles);
        while (left < right){
            int mid = left + (right - left)/2;
            if (canFinish(piles, mid, k)){
                // then try lower speed
                right = mid;
            } else {
                // try higher speed
                left = mid;
            }

        }
        return left;
    }
    public static int getMax(int[] arr){
        int max =0;
        for (int i: arr){
            max = Math.max(max, i);
        }
        return max;
    }

    public static boolean canFinish(int[] piles, int k, int H){
        int hours = 0;
        for (int pile: piles){
            hours += (pile+k-1)/k;
        }
        return hours <= H;
    }

    public static void main(String[] args) {
        int[] pilesOfBanana = {3, 6, 7, 11};
        int k = 8;
    }
}
