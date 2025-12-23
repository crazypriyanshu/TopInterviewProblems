package org.pdas.designPatterns.Behavioral.Visitor.vistorPattern;

public interface Visitor {
    public void visitBank(Bank bank);
    public void visitCompany(Company company);
    public void visitRestaurant(Restaurant restaurant);
    public void visitResident(Resident resident);
}
