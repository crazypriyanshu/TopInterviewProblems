package org.pdas.designPatterns.Behavioral.Visitor.vistorPattern;

public class Resident extends PotentialClient{
    private final String insuranceClass;

    public Resident(String name, String address, String number, String insuranceClass) {
        super(name, address, number);
        this.insuranceClass = insuranceClass;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitResident(this);
    }

    @Override
    public String toString() {
        return "Resident{" + super.toString() +
                "insuranceClass='" + insuranceClass + '\'' +
                '}';
    }
}
