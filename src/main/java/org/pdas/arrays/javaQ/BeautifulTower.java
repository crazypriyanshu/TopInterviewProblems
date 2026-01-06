package org.pdas.arrays.javaQ;

import java.util.ArrayList;

public class BeautifulTower {
    // you are given array A, representing the number of bricks in n consecutive towers.
    // your task is to remove some bricks to form a mountain shaped tower arrangement.
    // in this arrangement tower heights are non decreasing, reaching a maximum peak value with one or multiple conecutive towers and then non increasing
    // return the possible max sum of mountain shaped tower

    public static int maxSumOfHeights(ArrayList<Integer> A){
        int ans = 0;
        int n = A.size();
        for (int i=0; i< n; i++){
            int y = A.get(i);
            int temp = y;
            for(int j = i-1; j >= 0; j--){
                y = Math.min(y, A.get(j));
                temp += y;
            }
            y = A.get(i);
            for (int j = i+1; j< n; j++){
                y = Math.min(y, A.get(j));
                temp += y;
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] A = {5, 3, 4, 1, 1,};

    }
}
