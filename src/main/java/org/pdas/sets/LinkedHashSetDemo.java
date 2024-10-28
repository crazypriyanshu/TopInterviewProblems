package org.pdas.sets;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        // maintains insertion ordering of elements
        // cant store duplicates
        Set<Integer> set = new LinkedHashSet<>();
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
