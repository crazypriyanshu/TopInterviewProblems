package org.pdas.designPatterns.Behavioral.Visitor.vistorPattern;

public class VisitorPatterClient {
    public static void main(String[] args) {
        PotentialClient bankCLient = new Bank("SBI", "Mumbai", "90999099", "123");
        PotentialClient residentClient = new Resident("Bihm", "Trilai", "909879098", " Simple");
        PotentialClient restrauntClient = new Restaurant("Rama Hotel", " Sngadh", "78909876", "Solid");

        System.out.println(bankCLient);
        System.out.println(residentClient);
        System.out.println(restrauntClient);

        Visitor visitor = new InsuranceMessagingVisitor();
        bankCLient.accept(visitor);
        residentClient.accept(visitor);
        restrauntClient.accept(visitor);






    }
}
