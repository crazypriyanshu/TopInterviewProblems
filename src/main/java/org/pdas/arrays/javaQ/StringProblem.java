package org.pdas.arrays.javaQ;

import java.util.*;

public class StringProblem {
    // given a string containing lower case english letters of length n, you need to sort it in depending order based on the frequency of the characters and return sorted string
    // if characters have same frequency , they should be sorted alphabetically

    public static String stringSorter(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (a, b) -> {
            // first compare the frequency descending then by characters ascending
            int freqCompare = b.getValue().compareTo(a.getValue());
            return freqCompare != 0 ? freqCompare : a.getKey().compareTo(b.getKey());
        });
        // build the result
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: entries){
            char character = entry.getKey();
            int freq = entry.getValue();
            for (int i=0; i< freq; i++){
                result.append(character);
            }
        }
        return result.toString();

    }

    public static void main(String[] args) {
        String s = "priyanshu";
        System.out.println(stringSorter(s));

    }
}
