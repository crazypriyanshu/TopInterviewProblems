package org.pdas.arrays.javaQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentBElements {
    public static ArrayList<Integer> findTopBElements(int[] A, int B){
        // Step 1 : Count frequencies
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int a: A) {
            freq.put(a, freq.getOrDefault(a, 0)+1);
        }

        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((e1, e2) -> {
            if (!e1.getValue().equals(e2.getValue())) {
                return e2.getValue() - e1.getValue();
            } else {
                return e2.getKey() - e1.getKey();
            }
        });

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < B && i < list.size(); i++) {
            result.add(list.get(i).getKey());

        }
        return result;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] A = new int[n];
//        for (int i = 0; i < n; i++) {
//            A[i] = sc.nextInt();
//
//        }
//        int B = sc.nextInt();
//        sc.close();
        int[] A = {1,1,2,2,3,3,3,4};
        int B = 3;
        // freq 3 : 3,
        ArrayList<Integer> result = findTopBElements(A, B);
        for (int x: result) {
            System.out.print(x+" ");
        }
    }
}
