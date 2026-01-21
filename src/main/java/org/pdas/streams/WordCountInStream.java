package org.pdas.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WordCountInStream {
    /*
    * write a stream pipeline that takes a String,
    * splits it into words, and returns a Map<String, Long> showing the frequency of each word
    * */

    public static void main(String[] args) {
        String sentence = "This is a great opportunity";
        Map<String, Long> wordCountMap = Pattern.compile("\\s+").splitAsStream(sentence).collect(Collectors.groupingBy(
                word -> word,
                Collectors.counting()
        ));

        Arrays.stream(sentence.split("\\s+")).collect(Collectors.groupingBy(
                word -> word,
                Collectors.counting()
        )).forEach((word, count) -> System.out.println("Word: '"+word+"' appeared: "+count+" time(s)"));

        Arrays.stream(sentence.split("//s+")).collect(Collectors.groupingBy(word -> word, Collectors.counting())).entrySet().stream().forEach(entry -> System.out.println(entry.getKey()+" > "+entry.getValue()) );
        System.out.println(wordCountMap);
    }
}
