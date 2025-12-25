package org.pdas.designPatterns.Structural.flyWeight;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BookType {
    private final String fixedValue1;
    private final String getFixedValue2;
    private final String getGetFixedValue3;


    public BookType(String fixedValue1, String getFixedValue2, String getGetFixedValue3) {
        this.fixedValue1 = fixedValue1;
        this.getFixedValue2 = getFixedValue2;
        this.getGetFixedValue3 = getGetFixedValue3;
    }
}
