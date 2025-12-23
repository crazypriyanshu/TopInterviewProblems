package org.pdas.designPatterns.Behavioral.Visitor.vistorPattern;

public class Restaurant extends PotentialClient{
    private final String insuranceClass;

    public Restaurant(String name, String add, String number, String insuranceClass){
        super(name, add, number);
        this.insuranceClass = insuranceClass;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitRestaurant(this);
    }

    @Override
    public String toString() {
        return "Restaurant{" + super.toString() +
                "insuranceClass='" + insuranceClass + '\'' +
                '}';
    }
}
