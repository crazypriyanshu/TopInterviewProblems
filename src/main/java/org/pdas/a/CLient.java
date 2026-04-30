package org.pdas.a;

import org.pdas.arrays.javaQ.A;

import java.net.http.HttpClient;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CLient {
    public static void main(String[] args) {
//        Random random = new Random();
//        Speed1 speed1 = new Speed1();
//        Speed3 speed3 = new Speed3();
//        Speed5 speed5 = new Speed5();
//        Speed6 speed6 = new Speed6();
//        List<AbstractClassDemo> list = List.of(speed1, speed3, speed5, speed6);
        
//        AbstractClassDemo mainThread = new Initializer();
//        for (int i = 0; i < 10; i++) {
//            int player = random.nextInt(0, 3);
//            list.get(player).increment();
//            list.get(player).decrement();
//            System.out.println("Player "+i+" : "+list.get(player).getCount());
//        }
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).);
//        }
//        ClassA a1 = new ClassB();
//
//        ClassB b1 = new ClassB();
//        Long lval = Long.valueOf(10000);
//        b1.getNumber("hu", 8, 9, 002);
//        b1.getNumber((long) 900009909 , "wer");

//        Map<String, Integer> map = new HashMap<>();
//        map.put("A", 1);
//        map.putIfAbsent("B", 2);
//
//        for (Map.Entry<String, Integer> val : map.entrySet()){
//            String key = val.getKey();
//            Integer value = val.getValue();
//            System.out.println("Key "+key+" val: "+value);
//        }
//        Comparator<String> comp = (a, b) -> Integer.compare(a.length(), b.length());
//
//
//        Map<String, Integer> rack = new TreeMap<>(comp);
//        rack.put("Key", 1);
//        rack.put("Ring", 4);
//        rack.put("Coarse", 3);
//        System.out.println(rack.keySet());
//
//        Map<String, Integer> ranking = new TreeMap<>();
//        rack.put("Key", 1);
//        rack.put("Ring", 4);
//        rack.put("Coarse", 3);
//        rack.forEach((key, val) -> System.out.println(key+" == "+val));

//        AtomicInteger zeroCount = new AtomicInteger(0);
//        List<Integer> nums = List.of(1, -9, 0, 3,0, 0, 17, -1,0, 3);
//        List<Integer> res = nums.stream().sorted((a,b) -> {
//            if (a == 0 && b == 0) return 0;
//            if (a == 0) return -1;
//            if (b == 0) return 1;
//            return Integer.compare(a, b);
//        }).toList();
//        res.forEach(System.out::println);

//        List<Integer> sorted = nums.stream()
//                .filter(x -> x!= 0)
//                .sorted()
//                .toList();
//        List<Integer> result = Stream.concat(
//                Collections.nCopies((nums.size()- sorted.size()),0).stream(),
//                sorted.stream()
//        ).toList();
        printMonthDays(20);


    }

    private static void printMonthDays(int month){
        String m = switch(month) {
            case 1, 3, 5, 7, 8, 10, 12 -> "31";
            case 2 -> {
                boolean isLeap = java.time.Year.now().isLeap();
                yield isLeap ? "29" : "28";
            }
            case 4, 6,9, 11 -> "30";
            default -> "Unknown Month";
        };
        System.out.println(m);
    }
}