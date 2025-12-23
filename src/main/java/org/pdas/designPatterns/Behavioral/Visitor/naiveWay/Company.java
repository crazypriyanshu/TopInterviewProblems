package org.pdas.designPatterns.Behavioral.Visitor.naiveWay;

import lombok.Data;
import lombok.Getter;

@Getter
public class Company extends PotentialClient{
    private final int numberOfEmployees;
    public Company(String name, String add, String number, int numberOfEmployees){
        super(name, add, number);
        this.numberOfEmployees = numberOfEmployees;

    }

    @Override
    public void sendEmail() {
        System.out.println("Sending mail to Company : "+ getName()+ " "+ getAddress() + " "+ getNumber());
    }
}
