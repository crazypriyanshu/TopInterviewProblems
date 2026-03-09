package org.pdas.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayGround {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.addAll(List.of("Str", "Appl","c", "Science", "Boy", "Tron", "c", "Trent", "Str", "Chimp", "Ramn", "c","Science"));

        list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(System.out::println);

        ;
    }
}
