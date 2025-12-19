package org.pdas.designPatterns.Behavioral.State;

public class Client {
    public static void main(String[] args) {
        VendingMachineContext vendingMachineContext = new VendingMachineContext(new IdleState());
        vendingMachineContext.setSelectedItem("Aam");
        vendingMachineContext.setSelectedAmount(10.00);
        vendingMachineContext.setCurrentState(new DispensingState());
        vendingMachineContext.dispenseItem();

        System.out.println("2nd transaction");
        vendingMachineContext.setSelectedItem("Chomu");
        vendingMachineContext.setSelectedAmount(100.00);
        vendingMachineContext.dispenseItem();
    }
}
