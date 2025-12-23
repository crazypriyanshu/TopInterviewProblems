package org.pdas.designPatterns.Behavioral.Visitor.naiveWay;

import java.util.List;

public class RealClient {
    public static void main(String[] args) {
        PotentialClient potentialClient = new Resident("Ram", "Mumbai", "90941121", "Normal");
        PotentialClient potentialClient1 = new Bank("UCO", "Chennai", "900009099", "200");
        PotentialClient potentialClient2 = new Restaurant("Chalie Inn", "Rest more, 1-1", "909999099", true);
        System.out.println(potentialClient1);
        System.out.println(potentialClient);
        System.out.println(potentialClient2);
        List<PotentialClient> clients = List.of(potentialClient, potentialClient1, potentialClient2);
        clients.stream().forEach(c -> c.sendEmail());
    }
}
