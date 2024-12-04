package org.pdas.arrays;

import java.util.*;

/*
* Given an array of integers and a target number , find two numbers such that they add up to a specific target
* */
public class TwoSum {
    public static ArrayList<Integer> twoSum(final List<Integer> A, int B){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< A.size(); i++){
            int lookingFor = B - A.get(i);
            if (map.containsKey(lookingFor)){
                return new ArrayList<>(Arrays.asList(map.get(lookingFor)+1, i+1));
            }
            if (!map.containsKey(A.get(i))){
                map.put(A.get(i), i);
            }
        }
        return new ArrayList<>(Arrays.asList());


    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 7, 11));
        int target = 9;
        System.out.println(twoSum(list, target));

    }
}
