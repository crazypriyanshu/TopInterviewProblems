package org.pdas.arrays.mostAskedProblems.inventoryManagement;
/**
 * Represents an Inventory
 * We should be able to add items to Inventory
 * We should be able to remove item from inventory
 * */
public interface Inventory {
    public boolean addItem(Item item);
    public boolean addItemType(String name);
    public boolean removeItem(Item item);

}
