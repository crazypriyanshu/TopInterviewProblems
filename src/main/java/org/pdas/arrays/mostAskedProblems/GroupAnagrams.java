package org.pdas.arrays.mostAskedProblems;


import org.pdas.arrays.javaQ.A;

import java.util.*;

/**
 * Given array of String A, group the anagrams together
 * Return result in lexicographically sorted order
 * */
public class GroupAnagrams {

    private static List<List<String>> groupAnagrams(String[] A){
        if (A == null || A.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for (String s: A){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = chars.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> group: map.values()){
            Collections.sort(group);
            res.add(group);
        }

        res.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));
        return res;
    }

}
