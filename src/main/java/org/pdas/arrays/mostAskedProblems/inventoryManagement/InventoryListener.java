package org.pdas.arrays.mostAskedProblems.inventoryManagement;

public interface InventoryListener {
    void onThresholdBreach(String itemName, int currStock);
}
