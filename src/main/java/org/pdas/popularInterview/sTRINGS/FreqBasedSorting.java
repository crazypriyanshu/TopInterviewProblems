package org.pdas.popularInterview.sTRINGS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FreqBasedSorting {
    /*
    * Given a String A containing lowercase english letters of length N, we have to sort it in decreasing order on the frequency and return sorted string, if freq is same they should be sorted alphabetically
    * */

    public String freqBasedSorting(String A){
        if (A == null || A.isEmpty()) return "";

        int[] freqMap = new int[26];
        for (char c: A.toCharArray()){
            freqMap[c-'a']++;
        }

        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freqMap[i] > 0){
                characters.add((char) (i+'a'));
            }
        }

        characters.sort((c1,c2) -> {
            int f1 = freqMap[c1-'a'];
            int f2 = freqMap[c2-'a'];
            if (f1!= f2){
                return f2-f1;
            } else {
                return c1-c2;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (char c: characters){
            int count = freqMap[c-'a'];
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
