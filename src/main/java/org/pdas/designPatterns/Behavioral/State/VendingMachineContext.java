package org.pdas.designPatterns.Behavioral.State;

public class VendingMachineContext {
    private MachineState currentState;
    private String selectedItem;
    private Double selectedAmount;

    public VendingMachineContext(MachineState currentState) {
        this.currentState = new IdleState();
    }

    public void reset(){
        selectedItem = null;
        selectedAmount = 0.0;
        currentState = new IdleState();
    }

    public void dispenseItem(){
        currentState.dispenseItem(this);
    }

    public MachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(MachineState currentState) {
        this.currentState = currentState;
    }

    public String getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem = selectedItem;
    }

    public Double getSelectedAmount() {
        return selectedAmount;
    }

    public void setSelectedAmount(Double selectedAmount) {
        this.selectedAmount = selectedAmount;
    }
}
