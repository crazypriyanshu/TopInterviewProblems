package org.pdas.GoToBasics;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int n = 4, ans =0;
        for (int i = 1; i < 1 << n; i++) {
            int val = 20;
            for (int j = 0; j < n; j++) {
                if ((i >> j & 1) == 1){
                    val = Math.min(val, arrayList.get(j));
                }
            }
            ans += val;
        }
        System.out.println(ans);
    }
}
