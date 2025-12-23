package org.pdas.designPatterns.Behavioral.Visitor.vistorPattern;

import lombok.Getter;

@Getter
public class Bank extends PotentialClient{
    private String numberOfEmployees;

    public Bank(String name, String add, String number, String numberOfEmployees){
        super(name, add, number);
        this.numberOfEmployees = numberOfEmployees;

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitBank(this);
    }

    @Override
    public String toString() {
        return "Bank{" + super.toString() +
                "numberOfEmployees='" + numberOfEmployees + '\'' +
                '}';
    }
}
