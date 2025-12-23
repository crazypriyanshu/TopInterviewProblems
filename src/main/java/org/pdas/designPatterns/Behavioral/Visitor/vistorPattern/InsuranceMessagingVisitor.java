package org.pdas.designPatterns.Behavioral.Visitor.vistorPattern;

import java.util.List;

public class InsuranceMessagingVisitor implements Visitor{
    public void visitBank(Bank bank) {
        System.out.println("Sending mail to Bank : "+ bank.getName()+ " "+ bank.getAddress() + " "+ bank.getNumber());
    }

    @Override
    public void visitCompany(Company company) {
        System.out.println("Sending mail to Company : "+ company.getName()+ " "+ company.getAddress() + " "+ company.getNumber());
    }

    @Override
    public void visitRestaurant(Restaurant restaurant) {

        System.out.println("Sending mail to Restaurant : "+ restaurant.getName()+ " "+ restaurant.getAddress() + " "+ restaurant.getNumber());

    }

    @Override
    public void visitResident(Resident resident) {
        System.out.println("Sending mail to Resident : "+ resident.getName()+ " "+ resident.getAddress() + " "+ resident.getNumber());
    }

    public void sendInsuranceEmails(List<PotentialClient> clients){
        for (PotentialClient client : clients){
            client.accept(this);
        }

    }


}
