package org.pdas.maps;

import java.util.*;

public class ConvertMapToSorted {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Oranges", 2);
        map.put("Kiwi", 3);
        map.put("Mango", 4);
        map.put("Apple", 1);

        List<Map.Entry<String, Integer>> mapList = new ArrayList<>(map.entrySet());
        mapList.sort(Map.Entry.comparingByValue());
        System.out.println(mapList);

        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry: mapList){
            linkedHashMap.put(entry.getKey(), entry.getValue());

        }
        System.out.println(linkedHashMap);
    }
}
