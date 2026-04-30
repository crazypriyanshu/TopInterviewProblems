package org.pdas.arrays.mostAskedProblems.inventoryManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

public class CubicInventory{

    // below should contain ItemType and current quantity
    private final Map<String, AtomicInteger> inventory = new ConcurrentHashMap<>();
    // ItemType to minLimit mapping
    private final Map<String,Integer> minLimits = new HashMap<>();

    private final List<InventoryListener> listeners = new ArrayList<>();

    // callback for notification
    private BiConsumer<String, Integer> alertListener;


    /**
     * Registers a new itemType in inventory
     * */
    public void addItemType(String itemType, int initialLimit){
        inventory.putIfAbsent(itemType, new AtomicInteger(0));
        minLimits.put(itemType, initialLimit);

    }

    /**
     * add stock to inventory
     * */
    public void addItems(String itemType, int quantity){
        inventory.computeIfAbsent(itemType, k -> new AtomicInteger(0)).addAndGet(quantity);
    }

    /**
     * removeItems from inventory
     * */
    public void removeItems(String itemType, int quantity){
        AtomicInteger stock = inventory.get(itemType);
        if (stock == null){
            throw new IllegalStateException("ItemType: "+itemType+ " doesn't not exists");
        }
        if (stock.get() > quantity){
            System.out.println("Removing: "+itemType+" -> quantity: "+ quantity+" , current stock: "+(stock.get()-quantity));
            stock.addAndGet(-quantity);
        } else {
            System.out.println("Cant remove, itemType: "+itemType+ " has only "+stock.get()+" items left");
        }
        checkThreshold(itemType);
    }

    public void setMinLimit(String itemType, int limit){
        minLimits.put(itemType, limit);
    }

    /**
     * checkThreshold
     * */
    public void checkThreshold(String itemType){
        int currStock = 0;
        int minLimit = 0;
        if (inventory.containsKey(itemType)){
            currStock = inventory.get(itemType).get();
            if (minLimits.containsKey(itemType)){
                minLimit = minLimits.get(itemType);
            }
        }
        if(currStock < minLimit){
            System.out.println("Stock for itemType: "+itemType+" less than minLimit of: "+minLimit);
            notifyMinLimit(itemType, currStock);
        }
    }

    public void notifyMinLimit(String itemType, int currStock){
        for (InventoryListener listener: listeners){
            listener.onThresholdBreach(itemType, currStock);
        }
    }

    public void setAlertListener(BiConsumer<String, Integer> listener){
        this.alertListener = alertListener;
    }

    public void addListeners(InventoryListener listener){
        listeners.add(listener);
    }


}
