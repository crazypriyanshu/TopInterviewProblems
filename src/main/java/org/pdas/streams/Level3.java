package org.pdas.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CyclicBarrier;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Level3 {
    public static void main(String[] args) {
        // Given a List<String>, create a Map<String, Integer> where the key is the string and the value is its length,
        // but only for strings that don't contain the letter 'e'.
        List<String> words = List.of("Java", "JavaScript", "Python", "Job");
//        Map<String, Long> lengthMap = words.stream()
//                .collect(Collectors.groupingBy(
//                        word -> word,
//                        Collectors.counting()
//                ));
        Map<String, Integer> lengthMap = words.stream()
                        .collect(Collectors.toMap(
                                word -> word,
                                word -> word.length()
                        ));
        System.out.println(lengthMap);

        Map<String, Integer> res = words.stream()
                .filter(s -> !s.contains("J"))
                .collect(Collectors.toMap(
                        s -> s,
                        String::length
                ));
        System.out.println(res);

        // take a List<String> and convert into a map of word and reversed value of word
        var rev = words.stream()
                .collect(Collectors.toMap(
                        s -> s,
                        s -> new StringBuilder(s).reverse().toString()
                ));
        System.out.println(rev);
        System.out.println();
        List<Product> products = List.of(
                new Product("Laptop", 2200.0),
                new Product("Mouse", 120.0),
                new Product("Keyboard", 520.00),
                new Product("Screen", 1000.0)
        );
        // find the total cost of all the products whose size > 500
        products.stream()
                .filter(product -> product.price > 500)
                .mapToDouble(Product::price)
                .sum();

        // 13. Partitioning problem: you have list of numbers, divide them into odd and even
        List<Integer> sums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        sums.stream()
                .collect(Collectors.partitioningBy(n -> n%2==0))
                .entrySet()
                .forEach(System.out::println);
        // 14. find the longest String in a List<String>
        words.stream()
                .reduce((s1, s2)-> s1.length() >= s2.length() ? s1: s2)
                .ifPresent(System.out::println);
        // 15. skip and limit- Given [10, 20, 30, 40, 50, 60], sort descending, skip 2, take 3
        List<Integer> nums = List.of(10, 20, 30, 40, 50, 60);
        System.out.println();
        nums.stream().sorted(Comparator.reverseOrder()).skip(2).forEach(System.out::println);



    }

    public record Product(String name, double price){}


}
