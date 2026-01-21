package org.pdas.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Level1 {
    public static void main(String[] args) {
        // Given a List<Integer>,
        // find all even numbers, square each of them, and return the result as a List<Integer>.
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // Given a List<Integer>, find all even numbers,
        // square each of them, and return the result as a List<Integer>.
        integers.stream()
                .filter(val -> val % 2 == 0)
                .map(val -> val*val)
                .forEach(System.out::println);

        // Given a List<String>, return a list of strings that have a length greater than 3,
        // converted to all uppercase.
        List<String> words= Arrays.asList("java", "is", "cool", "nerd");
        words.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .forEach(System.out::println);

        int[] nums = {1, 2, 3, 4,5};
        // Given an array of primitives int[], find the sum of all odd numbers
        int sum = Arrays.stream(nums).filter(num -> num%2 != 0).sum();
        System.out.println(sum);

        List<String> fruits = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        // Given a List<String> containing duplicates,
        // return a Set of those strings in alphabetical order
        fruits.stream()
                .sorted()
                .collect(Collectors.toSet()).stream().forEach(System.out::println);

        List<String> someWords= Arrays.asList("fly", "sky", "apple", "gym");
        String first = someWords.stream()
                .filter(str -> "aeiou".indexOf(str.toLowerCase().charAt(0)) != -1)
                .findFirst()
                .orElse("None");
        System.out.println(first);

    }

}
