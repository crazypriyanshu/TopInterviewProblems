package org.pdas.designPatterns.Behavioral.Visitor.naiveWay;

import lombok.Data;
import lombok.Getter;

@Getter
public class Resident extends PotentialClient{
    private final String insuranceClass;

    public Resident(String name, String add, String number, String insuranceClass){
        super(name, add, number);
        this.insuranceClass = insuranceClass;
    }

    @Override
    public void sendEmail() {
        System.out.println("Sending mail to Resident : "+ getName()+ " "+ getAddress() + " "+ getNumber());
    }

    @Override
    public String toString() {
        return "Resident{" + super.toString()+
                " insuranceClass='" + insuranceClass + '\'' +
                '}';
    }
}
