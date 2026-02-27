package org.pdas.arrays.mostAskedProblems;

public class PainterPartition {
    /**
     * @param boardLength -int[] A - represents length of ith board
     * @param numberOfPainters - int - represents the number of painters
     * @param paintingTime - int - time taken by the painter to paint 1 unit of board
     *
     * @return time - int return the min time to paint all the boards
     *
     * Rules:
     *          1. All boards must be painted
     *          2. Board is a single unit - it can be painted by only 1 painter
     *          3. A painter can paint a contiguous section of board
     *          4. All painters can paint simultaneously
     * Problem : Find the min time to paint all the boards
     *
     * */
    private static int findMinTime(int[] boardLength, int numberOfPainters, int paintingTime){
        int low = 0, high = 0;
        for (int len: boardLength){
            low = Math.max(low, len);
            high += len;
        }

        int res = high;

        while (low <= high){
            int mid = low + (high-low)/2;
            if (isPaintingFeasible(boardLength, numberOfPainters, paintingTime, mid)){
                res = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return res;


    }

    private static boolean isPaintingFeasible(int[] boardLength, int numberOfPainters, int paintingTime, int limit) {
        int painters = 1;
        int currSum = 0;

        for (int len: boardLength){
            int costToPaintBoard = len * paintingTime;
            if (costToPaintBoard > limit) return false; // it is impossible to paint if the cost > limit
            if (currSum+costToPaintBoard > limit){
                painters++;
                currSum = len; // new painter starts with this board
                if (painters > numberOfPainters) return false;
            } else {
                currSum += len;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {10, 20, 30, 40};
        int B = 2;
        int cost = 1;
        // case 1 : painter1 - {10, 20} - time(30) and painter2{30, 40} time(70) => totTime = 70
        // case 2 : painter1 - {10, 20, 30} - time(60) and painter2{ 40} time(40) => totTime = 60
        // goal is to split array A into B contiguous sub-array such that the maximum sum among them is minimized

        System.out.println(findMinTime(A, B, cost));
    }
}
