package org.pdas.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Level2 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        // find average of squares of all odd numbers
         var ans = integers.stream().filter(i -> i%2 != 0)
                .mapToInt(s -> s*s)
                .average()
                 .orElse(0.00);
        System.out.println(ans);

        // find the total number of characters across all strings that start with the letter 'J'.
        List<String> words = List.of("Java", "JavaScript", "Python", "Job");
        Long answer = words.stream()
                .filter( s-> s.startsWith("J"))
                .collect(Collectors.counting());
        System.out.println(answer);

        // convert all strings to lowercase, and join them with a hyphen -
        String a = words.stream().map(String::toLowerCase).collect(Collectors.joining("-"));
        System.out.println(a);
        System.out.println();
        System.out.println();

        // List<Integer>, find the maximum value.
//        var n = integers.stream()
//                .sorted(Comparator.reverseOrder())
//                .collect(Collectors.toList())
//                        .stream()
//                .max(Comparator.comparing(Integer::intValue));
        integers.stream().max(Integer::compare).ifPresent(System.out::println);

        // Given a single String,
        // count how many times the letter 'a' appears (case-insensitive) using the Streams API.
        String s = "Java is amazing";
//        long count = Arrays.stream(s.chars().toArray())
//                .filter(ch -> ch == 'a')
//                .count();
//        System.out.println(count);
        s.toLowerCase().chars().filter(ch -> ch == 'a').count();
    }
}
