package org.pdas.designPatterns.Behavioral.Visitor.naiveWay;

import lombok.Data;
import lombok.Getter;

@Getter
public class Bank extends PotentialClient{
    private String numberOfEmployees;

    public Bank(String name, String add, String number, String numberOfEmployees){
        super(name, add, number);
        this.numberOfEmployees = numberOfEmployees;

    }

    @Override
    public void sendEmail() {
        System.out.println("Sending mail to Bank : "+ getName()+ " "+ getAddress() + " "+ getNumber());
    }

    @Override
    public String toString() {
        return "Bank{" + super.toString() +
                " , numberOfEmployees='" + numberOfEmployees + '\'' +
                '}';
    }
}
