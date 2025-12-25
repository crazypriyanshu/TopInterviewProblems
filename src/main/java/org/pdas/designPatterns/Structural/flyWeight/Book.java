package org.pdas.designPatterns.Structural.flyWeight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Book {
    private String name;
    private int price;
    private BookType bookType;

}
