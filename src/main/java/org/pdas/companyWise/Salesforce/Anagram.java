package org.pdas.companyWise.Salesforce;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Anagram {
    public static boolean areAnagrams(String s1, String s2){
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println(arr1.length + " _____ "+ arr2.length);
        IntStream.range(0, arr1.length).mapToObj(c -> arr1[c]).forEach(ch -> System.out.print((char) ch));
        System.out.println();
        IntStream.range(0, arr2.length).mapToObj(c -> arr2[c]).forEach(ch -> System.out.print((char) ch));
        System.out.println();
        return Arrays.equals(arr1, arr2);
    }
    public static void main(String[] args) {
        System.out.println(areAnagrams("listen", "silent")); // true
        System.out.println(areAnagrams("hello", "world"));   // false
    }
}
