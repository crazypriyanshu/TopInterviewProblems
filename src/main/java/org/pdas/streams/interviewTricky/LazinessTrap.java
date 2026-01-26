package org.pdas.streams.interviewTricky;

import java.util.List;

public class LazinessTrap {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.stream()
                .filter(n -> {
                    System.out.print("filter "+n+ " ||");
                    return n % 2 == 0;
                })
                .map(n -> {
                    System.out.print("map "+n+" ");
                    return 2*n;
                }).forEach(n -> System.out.println("forEach "+ n+ " "));
        System.out.println("done");
    }
}
