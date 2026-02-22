package org.pdas.popularInterview.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RainWaterTapping {
    /*
    * Given a array of Integers which has the height of building , find the total water trapped.
    * */

    private static int waterTrapped(ArrayList<Integer> heights){
        if (heights == null || heights.isEmpty()) return 0;

        int n = heights.size();
        int left =0;
        int right = n-1;
        int leftMax = heights.get(left);
        int rightMax = heights.get(right);
        int totWater = 0;

        while (left < right){
            if (heights.get(right) > heights.get(left)){
                if (heights.get(left) > leftMax){
                    leftMax = heights.get(left);
                } else {
                    totWater += leftMax - heights.get(left);
                }
                left++;
            } else {
                if (heights.get(right) > rightMax){
                    rightMax = heights.get(right);
                } else {
                    totWater += rightMax - heights.get(right);
                }
                right--;
            }
        }
        return totWater;
    }

    public static void main(String[] args) {
        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(1);
        heights.add(0);
        heights.add(1);
        heights.add(0);
        heights.add(2);

        System.out.println(waterTrapped(heights));
    }
}