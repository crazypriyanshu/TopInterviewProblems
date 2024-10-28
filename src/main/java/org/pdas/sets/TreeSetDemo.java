package org.pdas.sets;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        // maintains and stores natural order
        Set<Integer> set = new TreeSet<>();
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
