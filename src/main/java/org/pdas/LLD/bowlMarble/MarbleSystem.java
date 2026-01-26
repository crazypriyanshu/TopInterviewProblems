package org.pdas.LLD.bowlMarble;

import java.util.ArrayList;
import java.util.List;

public class MarbleSystem {
    private final List<Bowl> bowls;

    public MarbleSystem(int numberOfBowls, int capacityPerBowl){
        bowls = new ArrayList<>();
        for (int i=0; i < numberOfBowls; i++){
            bowls.add(new Bowl(i, capacityPerBowl));
        }
    }

    public void addMarbleToBowl(int index){
        if (index < 0 || index >= bowls.size()){
            throw new IllegalStateException("Invalid bowl index");
        }

        boolean carry = bowls.get(index).addMarble();
        int nextIndex = index-1;
        while (carry && nextIndex >= 0){
            carry = bowls.get(index).addMarble();
            nextIndex--;
        }

        if (carry){
            System.out.println("Bowl 0 exceeded capacity");
        }
    }

    public void printState(){
        bowls.forEach(bowl -> System.out.println("["+bowl.getCurrentMarbles()+"] "));
        System.out.println();
    }

    public static void main(String[] args) {
        MarbleSystem marbleSystem = new MarbleSystem(2, 5);
        for (int i = 1; i < 5; i++) {
            marbleSystem.addMarbleToBowl(i);
            marbleSystem.printState();
        }
    }
}
