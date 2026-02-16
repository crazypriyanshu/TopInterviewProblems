package org.pdas.popularInterview;

import org.pdas.arrays.javaQ.A;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringProblem {
    /*
    * Given a String s = "Apple Guava Apple Berry";
    * return outputArray as {Apple2, Guava1, Berry1};
    * */

    private static String[] solveStringProblem(String input){
        if (input == null) return new String[] {};


        String[] brokenString = input.split(" ");
        String[] result = new String[brokenString.length];
        Map<String, Integer> map = new HashMap<>();
        for (String s: brokenString){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        int index = 0;
        for (Map.Entry<String, Integer> val: map.entrySet()){
            result[index++] = val.getKey()+val.getValue();
        }

        return result;
    }

    public static void main(String[] args) {
        String A = "Apple Banana Apple Cherry";
        Arrays.stream(solveStringProblem(A)).forEach(System.out::println);
    }
}
