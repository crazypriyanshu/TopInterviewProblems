package org.pdas.advancedDSA.greedy;

import java.util.Arrays;

public class FractionalKnapsack {
    /*
    * Given 2 integer arrays of size n A and B - A contains the values and B contains the weight
    * Also an integer C is given for maximumKnapsack capcity
    * Find out max total capacity we can fit in knapsack
    * We can break an item so that we can fit into knapsack
    * */

    static class Item{
        int value, weight;
        double ratio;
        Item(int value, int weight){
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value/weight;
        }
    }
    public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        Item[] items = new Item[n];
        for(int i=0; i< n; i++){
            items[i] = new Item(A[i], B[i]);
        }
        Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));
        double maxValue = 0.0;
        int currentCapacity = C;

        for(Item item: items){
            if(currentCapacity == 0) break;


            if(item.weight <= currentCapacity){
                // take whole item
                maxValue += item.value;
                currentCapacity -= item.weight;
            } else{
                maxValue += item.ratio * currentCapacity;
                currentCapacity = 0;
            }
        }

        return (int) Math.floor(maxValue* 100+ 1e-9);

    }
}
