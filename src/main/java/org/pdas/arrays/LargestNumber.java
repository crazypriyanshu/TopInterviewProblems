package org.pdas.arrays;

import java.util.*;

public class LargestNumber {
    public static String greatestNumber(List<Integer> list) {
        int n = list.size();
        StringBuilder stringBuilder = new StringBuilder();
        List<String> stringList = new ArrayList<>();
        for (Integer num: list){
            stringList.add(String.valueOf(num));
        }
        Collections.sort(stringList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1+o2;
                String order2 = o2+o1;
                return order2.compareTo(order1);
            }
        });

        if (stringList.get(0).equals("0")){
            return "0";
        }
        for (String num: stringList){
            stringBuilder.append(num);
        }

        return stringBuilder.toString();



    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(3);
        arr.add(9);
        arr.add(0);
        System.out.println(greatestNumber(arr));

    }
}
