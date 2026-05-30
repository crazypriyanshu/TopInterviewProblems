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

        var ans = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//                .entrySet().stream()
//                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
//                .forEach(System.out::println);


        ;
        for (Map.Entry<String, Long> entry: ans.entrySet()){
            System.out.println("String: "+entry.getValue()+" : "+entry.getKey());
        }
        System.out.println("val is: "+ testMethod());


    }

    private static int testMethod(){
        try {
            return 10;
        } catch (Exception e) {
            return 20;
        } finally {
            return 30;
        }
    }
}
