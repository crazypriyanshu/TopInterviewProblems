package org.pdas.backtracking;

import java.util.*;

public class utilityTestCasePermutation {
    static List<Map<String, String>> generateConfigs(List<String> keys, Map<String, List<String>> values){
        List<Map<String, String>> result = new ArrayList<>();
        backtrack(0, keys, values, new HashMap<>(), result);
        return result;
    }

    static void backtrack(int index,
                          List<String> keys,
                          Map<String, List<String>> values,
                          Map<String, String> current, // path
                          List<Map<String, String>> result // result
                          ){
        if (index == keys.size()){
            result.add(new HashMap<>(current));
            return;
        }
        String key = keys.get(index);
        for (String val: values.get(key)){
            current.put(key, val);
            backtrack(index+1, keys, values, current, result);
            current.remove(key);
        }
    }


    public static void main(String[] args) {
        // problem: we have 3 configs:
        // A = {ON, OFF}
        //B = {ENABLED, DISABLED}
        //C = {TRUE, FALSE}
        // I need to generate all possible types of configs for testing
        String[] A = {"ON", "OFF"};
        String[] B = {"ENABLED", "DISABLED"};
        String[] C = {"TRUE", "FALSE"};
        List<String> values = Arrays.asList("ON", "OFF");
        List<String> values2 = Arrays.asList("ENABLED", "DISABLED");
        List<String> values3 = Arrays.asList("TRUE", "FALSE");
        Map<String, List<String>> map = new HashMap<>();
        List<String> keys = Arrays.asList("State", "Condition", "SafetlyON");
        map.put(keys.get(0), values);
        map.put(keys.get(1), values2);
        map.put(keys.get(2), values3);
        generateConfigs(keys, map).stream().forEach(System.out::println);
    }
}
