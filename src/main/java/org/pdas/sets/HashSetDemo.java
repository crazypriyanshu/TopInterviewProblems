package org.pdas.sets;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        // HashSets store the data in the form of a tree structure, where head is the lowest element
        // Can't store duplicates
        // is very fast
        // internal working is a HashSet
        set.add(1);
        System.out.println(set);
        set.add(4);
        System.out.println(set);
        set.add(2);
        System.out.println(set);
        set.add(5);
        System.out.println(set);
        set.add(7);
        System.out.println(set);
        set.add(9);
        System.out.println(set);
    }
}
