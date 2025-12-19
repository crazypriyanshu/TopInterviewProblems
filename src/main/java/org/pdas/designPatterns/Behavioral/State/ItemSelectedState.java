package org.pdas.designPatterns.Behavioral.State;

public class ItemSelectedState implements MachineState{
    @Override
    public void selectItem(VendingMachineContext context, String itemCode) {

    }

    @Override
    public void payMoney(VendingMachineContext context, Double amount) {

    }

    @Override
    public void dispenseItem(VendingMachineContext context) {

    }
}
