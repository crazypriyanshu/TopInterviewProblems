package org.pdas.designPatterns.Behavioral.State;

public class HasMoneyState implements MachineState{
    @Override
    public void selectItem(VendingMachineContext context, String itemCode) {
        System.out.println("Cant change item after dispensing money, you already have selected : "+ context.getSelectedItem());

    }

    @Override
    public void payMoney(VendingMachineContext context, Double amount) {
        System.out.println("Money is already inserted or paid");

    }

    @Override
    public void dispenseItem(VendingMachineContext context) {
        System.out.println("Dispensing the item : "+ context.getSelectedItem());
        context.setCurrentState(new DispensingState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Item dispensed success..");
        context.reset();

    }
}
