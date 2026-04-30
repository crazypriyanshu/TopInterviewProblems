package org.pdas.arrays.mostAskedProblems.inventoryManagement;

public class Client {
    public static void main(String[] args) {
        CubicInventory inventory = new CubicInventory();
        inventory.addListeners(new PopUpAlertListener());
        inventory.addItemType("Ball", 0);
        inventory.addItemType("Bat", 0);
        inventory.addItemType("Wicket", 0);
        inventory.addItemType("Pads", 0);

        inventory.addItems("Ball", 100);
        inventory.addItems("Bat", 100);
        inventory.addItems("Wicket", 100);
        inventory.addItems("Pads", 100);

        inventory.setMinLimit("Ball", 20);
        inventory.setMinLimit("Bat", 20);
        inventory.setMinLimit("Wicket", 20);
        inventory.setMinLimit("Pads", 20);

        inventory.removeItems("Ball", 20);
        inventory.removeItems("Bat", 90);
        inventory.removeItems("Wicket", 82);
        inventory.removeItems("Pads", 10);

    }
}
