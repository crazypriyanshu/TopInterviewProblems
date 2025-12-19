package org.pdas.designPatterns.Behavioral.State;

public class NaiveVendingMachine {
    private enum State {
        IDLE, ITEM_SELECTED, HAS_MONEY, DISPENSING
    }

    private State currentState = State.IDLE;
    private String selectedItem = "";
    private Double insertedAmount = 0.0;


    public void selectItem(String itemCode){
        switch (currentState) {
            case IDLE:
                selectedItem = itemCode;
                currentState = State.ITEM_SELECTED;
                break;
            case ITEM_SELECTED:
                System.out.println("Item already selected");
                break;
            case HAS_MONEY:
                System.out.println("Money received");
                break;
            case DISPENSING:
                System.out.println("Currently dispensing");
            case null, default:
                System.out.println("Something is wrong...");
        }
    }

    public void payMoney(Double amount){
        switch (currentState){
            case ITEM_SELECTED:
                insertedAmount = amount;
                System.out.println("Inserted "+ amount+ " amount in vending machine");
                currentState = State.HAS_MONEY;
                break;
            case IDLE:
                System.out.println("No items selected");
                break;
            case HAS_MONEY:
                System.out.println("Money already inserted");
                break;
            case DISPENSING:
                System.out.println("Currently dispensing");
        }
    }

    public void dispenseItem(){
        switch (currentState){
            case DISPENSING:
                System.out.println("Currently dispensing...");
                break;
            case IDLE:
                System.out.println("No items selected");
                break;
            case HAS_MONEY:
                System.out.println("Dispensing item : "+selectedItem+ " ..");
                currentState = State.DISPENSING;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Item dispensed");
                break;
            case ITEM_SELECTED:
                System.out.println("Enter money first");
                break;

        }
    }

    private void resetMachine(){
        selectedItem = null;
        insertedAmount = 0.0;
        currentState = State.IDLE;
    }
}
