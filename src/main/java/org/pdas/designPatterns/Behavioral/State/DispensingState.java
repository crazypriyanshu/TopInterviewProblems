package org.pdas.designPatterns.Behavioral.State;

public class DispensingState implements MachineState{
    @Override
    public void selectItem(VendingMachineContext context, String itemCode) {
        System.out.println("Already dispensing item, cant select any item now");
    }

    @Override
    public void payMoney(VendingMachineContext context, Double amount) {
        System.out.println("Already money is paid, dispensing the item");

    }

    @Override
    public void dispenseItem(VendingMachineContext context) {
        System.out.println("Dispensing is in progress");

    }
}
