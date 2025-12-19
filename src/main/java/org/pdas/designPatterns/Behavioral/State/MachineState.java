package org.pdas.designPatterns.Behavioral.State;

public interface MachineState {
    public void selectItem(VendingMachineContext context, String itemCode);
    public void payMoney(VendingMachineContext context, Double amount);
    public void dispenseItem(VendingMachineContext context);
}
