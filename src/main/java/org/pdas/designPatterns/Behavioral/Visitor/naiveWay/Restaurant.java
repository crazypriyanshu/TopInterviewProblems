package org.pdas.designPatterns.Behavioral.Visitor.naiveWay;

import lombok.Data;
import lombok.Getter;

@Getter
public class Restaurant extends PotentialClient{
    public final boolean isAvailable;
    public Restaurant(String name, String add, String number, boolean isAvailable){
        super(name, add, number);
        this.isAvailable = isAvailable;
    }

    @Override
    public void sendEmail() {
        System.out.println("Sending mail to Restaurant : "+ getName()+ " "+ getAddress() + " "+ getNumber());
    }

    @Override
    public String toString() {
        return "Restaurant{" + super.toString() +
                " ,isAvailable=" + isAvailable +
                '}';
    }
}
