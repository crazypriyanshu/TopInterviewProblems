package org.pdas.designPatterns.Behavioral.Visitor.naiveWay;

import lombok.Data;

@Data
public abstract class PotentialClient {
    private final String name;
    private final String address;
    private final String number;

    public abstract void sendEmail();

    @Override
    public String toString() {
        return "PotentialClient{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
