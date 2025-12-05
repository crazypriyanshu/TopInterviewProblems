package org.pdas.companyWise.Salesforce;

import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static String removeDuplicates(String s){
        boolean[] seen = new boolean[256];
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if ((!seen[c])){
                seen[c] = true;
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        System.out.println(removeDuplicates(input));
        System.out.println(removeDuplicatess(input));
    }

    public static String removeDuplicatess(String s) {
        return s.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .distinct()
                .collect(Collectors.joining());
    }
}
