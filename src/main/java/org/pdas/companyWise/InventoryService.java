package org.pdas.companyWise;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

;
public class InventoryService {
    private static final Map<Item, AtomicInteger> stock = new ConcurrentHashMap<>();

    public InventoryService(){

    }

    public static void addItem(Item item, int quantity){

        try {
            System.out.println();
            System.out.println("Adding stock");
            stock.computeIfAbsent(item, k -> new AtomicInteger(0)).addAndGet(quantity);
        } catch (Exception e) {
            System.out.println("Unable to add item for: "+item.name()+ " for quantity: "+quantity);
            throw new RuntimeException(e);
        }
    }

    public static void displayStock(){
        for (Item prod: stock.keySet()){
            System.out.println("Product "+prod.name()+ " stock: "+stock.get(prod).toString());
        }
    }

    public static void sellItem(Item item, int quantity){
        try {
            // stock.computeIfPresent(item, (key, val) -> stock.get(key)).decrementAndGet();
            stock.merge(item, new AtomicInteger(quantity), (oldVal, newVal) -> {
                if (oldVal.addAndGet(-quantity) >= 0){
                    return oldVal;
                } else {
                    throw new RuntimeException("Can NOT process this request, as "+oldVal+" in stock");
                }
            });
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Item item1 = new Item("Pen", 1);
        Item item2 = new Item("Notebook", 2);
        Item item3 = new Item("Eraser", 3);

        addItem(item1, 100);
        addItem(item2, 20);
        addItem(item3, 20);
        displayStock();

        sellItem(item1, 20);
        displayStock();
        sellItem(item2, 30);
        displayStock();
        sellItem(item2, 15);
        displayStock();
        
    }
}
