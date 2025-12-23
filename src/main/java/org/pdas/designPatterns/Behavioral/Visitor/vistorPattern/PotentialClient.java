package org.pdas.designPatterns.Behavioral.Visitor.vistorPattern;

import lombok.Data;

@Data
public abstract class PotentialClient {
    private final String name;
    private final String address;
    private final String number;

    public abstract void accept(Visitor visitor);

    @Override
    public String toString() {
        return "PotentialClient{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
