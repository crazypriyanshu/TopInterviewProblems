package org.pdas.arrays.mostAskedProblems.inventoryManagement;

import java.util.List;

public class ItemType {
    private int id;
    private String itemType;
    private List<Item> items;

    public ItemType(int id, String itemType) {
        this.id = id;
        this.itemType = itemType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "ItemType{" +
                "id=" + id +
                ", itemType='" + itemType + '\'' +
                ", items=" + items +
                '}';
    }
}
