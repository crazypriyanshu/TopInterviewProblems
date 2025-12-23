package org.pdas.designPatterns.Behavioral.Visitor.vistorPattern;

public class Company extends PotentialClient{
    private final int numberOfEmployees;
    public Company(String name, String add, String number, int numberOfEmployees){
        super(name, add, number);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitCompany(this);
    }

    @Override
    public String toString() {
        return "Company{" + super.toString() +
                "numberOfEmployees=" + numberOfEmployees +
                '}';
    }
}
