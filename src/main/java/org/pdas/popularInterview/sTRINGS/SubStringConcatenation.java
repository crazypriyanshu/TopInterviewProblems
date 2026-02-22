package org.pdas.popularInterview.sTRINGS;

import java.util.*;

public class SubStringConcatenation {
    /*
    * You are given a String, A, and a list of words B, in which all words are of same length
    * Find all starting indices of substring(s) in S that is concatenation of each word in B exactly once and without any intervening characters
    * A concatenated string is a string that contains all the substrings of any permutation of words concatenated.
    * Eg. if words = ["ab", "cd", "ef"] then "abcdef", "abefcd", "cdefab" "efcdab" are all concatenated Strings
    * Return an array of starting indices of all concatenated substrings in A in increasing order
    * */

    public ArrayList<Integer> findSubstring(String A, final List<String> B) {
        ArrayList<Integer> result = new ArrayList<>();
        if(A == null || B == null || B.size() == 0) return result;

        int n = A.length();
        int m = B.size();
        int wordLen = B.get(0).length();

        Map<String, Integer> wordCount = new HashMap<>();
        for(String word: B){
            wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
        }

        for(int i=0; i< wordLen; i++){
            Map<String, Integer> windowMap = new HashMap<>();
            int count =0;
            int left = i;

            for(int j=i; j <= n-wordLen; j += wordLen){
                String word = A.substring(j, j+wordLen);

                if(wordCount.containsKey(word)){
                    windowMap.put(word, windowMap.getOrDefault(word,0)+1);
                    count++;

                    while(windowMap.get(word) > wordCount.get(word)){
                        String leftWord = A.substring(left, left+wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord)-1);
                        count--;
                        left += wordLen;
                    }
                    if(count == m){
                        result.add(left);
                    }
                } else{
                    windowMap.clear();
                    count = 0;
                    left = j+wordLen;
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
