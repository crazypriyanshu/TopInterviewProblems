package org.pdas.designPatterns.Structural.flyWeight;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Data
@ToString
public class Store {
    private final List<Book> books = new ArrayList<>();
    public void storeBooks(String name, int price, String fixedData1, String fixedData2, String fixedData3){
        // BookType bookType = new BookType(fixedData1, fixedData2, fixedData3); // anti-pattern
        BookType bookType = BookFactory.getBookType(fixedData1, fixedData2, fixedData3);
        books.add(new Book(name, price, bookType));
    }

    public void displayBook(){
        for (Book book: books){
            System.out.println("Book is "+book);
        }
    }
}
