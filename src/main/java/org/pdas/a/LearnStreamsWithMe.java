package org.pdas.a;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

record Book(int id, String name, String genre, int price){}
public class LearnStreamsWithMe {
    public static void main(String[] args) {
        Book book1 = new Book(1, "Harry Porter", "Thriller", 200);
        Book book2 = new Book(2, "Wonderful time", "Romantic", 100);
        Book book3 = new Book(3, "Data intensive Applications", "Tech", 1030);
        Book book4 = new Book(4, "Data Ingestion", "Tech", 150);
        Book book5 = new Book(5, "Clean Code", "Tech", 1250);

        List<Book> library = List.of(book1, book2, book3, book4, book5);
        Map<String, Long> perGenre = library.stream()
                .collect(Collectors.groupingBy(
                        Book::genre,
                        Collectors.counting()
                ));


        // find average price per genre
        LinkedHashMap<String, List<Integer>> ans = library.stream()
                .collect(Collectors.groupingBy(
                       //Function: extracts key
                       Book::genre,
                       // Supplier
                       LinkedHashMap::new,
                       // collector
                       Collectors.mapping(x -> x.price()*x.price(), Collectors.toList())
                ));
        System.out.println(ans);
    }
}
