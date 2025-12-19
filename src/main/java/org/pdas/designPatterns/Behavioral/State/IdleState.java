package org.pdas.designPatterns.Behavioral.State;

public class IdleState implements MachineState{
    @Override
    public void selectItem(VendingMachineContext context, String itemCode) {
        System.out.println("Item selected : "+ itemCode);
        context.setSelectedItem(itemCode);
        context.setCurrentState(new ItemSelectedState());
    }

    @Override
    public void payMoney(VendingMachineContext context, Double amount) {
        System.out.println("Please select an item before paying money");

    }

    @Override
    public void dispenseItem(VendingMachineContext context) {
        System.out.println("No item selected and hence nothing to dispense");

    }
}
