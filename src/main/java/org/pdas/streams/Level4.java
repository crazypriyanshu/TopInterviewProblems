package org.pdas.streams;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Level4 {
    public static void main(String[] args) {
        // 16. Grouping by length -{1 = [Java, Jobs], 5 =[Python]}
        List<String> words = List.of("Java", "JavaScript", "Python", "Jobs", "AlphaChino");
        words.stream()
                .collect(Collectors.groupingBy(
                String::length)
                ).entrySet().forEach(System.out::println);

        // 17. count how many strings exists for each length
        System.out.println("****** how many strings exists for each length *******");
        List<String> input = List.of("a", "bb", "c", "dd", "eee");
        input.stream()
                .collect(Collectors.groupingBy(s -> s.length()))
                .entrySet()
                .stream().collect(Collectors.toMap(
                        i -> i.getKey(),
                va-> va.getValue().size()
                ))
                .entrySet().stream()
                .forEach(System.out::println);

        // 18. Mapping inside a group, input = ["apple", "apricot", "banana", "cherry"]
        // out : {a=[5, 7], b=[6], c=[6]}
        List<String> fruits = List.of("apple", "apricot", "banana", "cherry", "zebra");
        fruits.stream()
                .collect(Collectors.groupingBy(s -> s.length()))
                .entrySet()
                .forEach(System.out::println);

        List<String> wordList = List.of("a", "bb", "c", "dd", "eee");
        // 17. group these by length
        wordList.stream().collect(Collectors.groupingBy(s -> s.length())).entrySet().forEach(System.out::println);
        System.out.println();
        var si = wordList.stream()
                .filter(s -> s != null && !s.isEmpty())
                .collect(Collectors.groupingBy(
                s -> s.toLowerCase().charAt(0), // how to group
                Collectors.counting() // value
        ));
        System.out.println("*******");
        System.out.println(si);

        System.out.println("****************** 19. summing by group : Given a list with duplicate names, find the total sum of prices for each product name.******************");
        Product product1 = new Product("Laptop", 1000);
        Product product2 = new Product("Mouse", 20);
        Product product3 = new Product("Laptop", 200);
        List<Product> products = List.of(product1, product2, product3);
        products.stream().filter(p -> p != null).collect(Collectors.groupingBy(
                Product::name,
                Collectors.summingInt(Product::price)
        )).entrySet().forEach(System.out::println);

        System.out.println("***** 20. MaxBy Category Challenge: Find the most expensive product in each category. *****");
        IProduct iProduct1 = new IProduct("iPhone", "Tech", 1000);
        IProduct iProduct2 = new IProduct("Samsung", "Tech", 900);
        IProduct iProduct3 = new IProduct("Bread", "Food", 2);
        IProduct iProduct4 = new IProduct("Steak", "Food", 30);
        List<IProduct> iProductList = List.of(iProduct1, iProduct2, iProduct3, iProduct4);
        iProductList.stream()
                .filter(s -> s != null)
                .collect(Collectors.groupingBy(
                    IProduct::category,
                    Collectors.maxBy(Comparator.comparingInt(IProduct::price)))
                )
                .entrySet()
                .forEach(System.out::println);

        // find the average price of product in each category
        String ans = iProductList.stream().filter(s -> s != null).collect(Collectors.groupingBy(
                IProduct::category,
                Collectors.averagingInt(IProduct::price)
        )).toString();
        System.out.println("*****************");
        System.out.println(ans);


        System.out.println("*************** 23 . Multiple Aggregations (Summarizing) ********");
        // Find the count, sum, min, average, and max of all numbers in a List<Integer> using one single collector.
        Map<String, IntSummaryStatistics> an = iProductList.stream().collect(Collectors.groupingBy(IProduct::category, Collectors.summarizingInt(IProduct::price)));
        System.out.println(an);

        System.out.println("*************** 24 . Filtering INSIDE a Group ********");
        // Given a List<Integer>, group them by n % 2 == 0 (Even vs Odd), but for the values, only include numbers that are greater than 10.
        List<Integer> nums = List.of(2, 12, 5, 15, 8, 18);
        Map<Boolean, List<Integer>> ani = nums.stream().collect(Collectors.groupingBy(s -> s%2 == 0, Collectors.filtering(s -> s > 10, Collectors.toList())));
        System.out.println(ani);

        System.out.println("******** 25. Flattening the map **************");






    }
    public record Product(String name, int price){}
    public record IProduct(String name, String category, int price){}
}
