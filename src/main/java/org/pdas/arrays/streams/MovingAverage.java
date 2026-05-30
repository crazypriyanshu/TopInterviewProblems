package org.pdas.arrays.streams;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

record Transaction(String category, int amount, String currency, int
                    id){}
public class MovingAverage {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int interval = 3;
        // find the moving average of k elements
        List<Double> ans = IntStream.range(0, list.size()-interval+1)
                .mapToDouble(i -> list.subList(i, i+interval).stream()
                        .mapToInt(Integer::intValue)
                        .average().orElse(0.00)
                )
                .boxed()
                .collect(Collectors.toList());
        ans.forEach(System.out::println);

        Transaction t1 = new Transaction("DEBIT", 100, "INR", 1);
        Transaction t2 = new Transaction("CREDIT", 200, "INR", 2);
        Transaction t3 = new Transaction("DEBIT", 500, "INR", 3);
        Transaction t4 = new Transaction("CREDIT", 800, "INR", 5);

//        List<Transaction> transactionList = List.of(t1, t2, t3, t4);
//        // Given a list of Transaction objects find the highest transaction amount for each category, but return it as a Map<String, Optional<Double>>.
//        Map<String, Optional<Integer>> li = transactionList.stream()
//                .collect(Collectors.groupingBy(
//                        Transaction::category,
//                        Collectors.mapping(Transaction::amount, Collectors.counting().accumulator((k, v) -> Collectors.toMap() )
//                ));
//        li.forEach((k, v) -> System.out.println("Key: "+k+" value: "+v.get()));


    }
}
