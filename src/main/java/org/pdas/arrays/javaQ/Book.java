package org.pdas.arrays.javaQ;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Book implements Cloneable{
    private String title;
    private Author author;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Book clonedBook = (Book) super.clone();
//        clonedBook.author = (Author) author.clone();
        return clonedBook;
    }

}
