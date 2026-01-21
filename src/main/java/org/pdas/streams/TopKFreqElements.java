package org.pdas.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFreqElements {
    /*
    * Given a list of String, return top 3 most frequent strings
    * */

    public static void main(String[] args) {
        List<String> words = List.of("Zebra", "A", "App", "Something", "Zebra");
        words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                .limit(3)
                .map(Map.Entry::getKey)
                .toList().forEach(System.out::println);



    }
}
