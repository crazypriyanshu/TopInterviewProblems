package org.pdas.popularInterview.experiment;

public class Client {
    public static void main(String[] args) {

        Parent p = new Child();
        System.out.println(p.name);
        p.print();
    }
}
