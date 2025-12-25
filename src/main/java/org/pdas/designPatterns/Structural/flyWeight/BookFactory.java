package org.pdas.designPatterns.Structural.flyWeight;

import java.util.HashMap;
import java.util.Map;

public class BookFactory {
    public static final Map<String, BookType> bookTypeMap = new HashMap<>();
    public static BookType getBookType(String fixedValue1, String fixedValue2, String fixedValue3){
        if (bookTypeMap.get(fixedValue1) == null){
            bookTypeMap.put(fixedValue1, new BookType(fixedValue1, fixedValue2, fixedValue3));
        }
        return bookTypeMap.get(fixedValue1);
    }
}
