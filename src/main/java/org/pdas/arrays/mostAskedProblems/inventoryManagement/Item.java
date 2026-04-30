package org.pdas.arrays.mostAskedProblems.inventoryManagement;

import java.time.LocalDateTime;

public class Item {
    private int id;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime expiryDate;
    private String description;
    private ItemType itemType;

    Item(int id, String name, LocalDateTime expiryDate, ItemType itemType){
        this.id = id;
        this.name = name;
        this.itemType = itemType;
        this.expiryDate = expiryDate;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdAt=" + createdAt +
                ", expiryDate=" + expiryDate +
                ", description='" + description + '\'' +
                ", itemType=" + itemType +
                '}';
    }
}
