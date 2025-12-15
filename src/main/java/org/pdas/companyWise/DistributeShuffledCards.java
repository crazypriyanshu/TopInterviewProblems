package org.pdas.companyWise;

import java.util.*;

public class DistributeShuffledCards {
    // N number of cards need to be share to N number of player
    public static HashMap<String, String> distributeCardsToNPlayer(int N){
        if (N < 0){
            System.out.println("Number of player must be more than 0");
            return new HashMap<>();
        }
        List<String> deck = new ArrayList<>();
        for (int i=0; i< N; i++){
            deck.add("Card"+(i+1));
        }
        Collections.shuffle(deck);
        HashMap<String, String> distributions = new HashMap<>();
        for (int i = 0; i< N; i++){
            String playerName = "Player"+(i+1);
            String cardToAssign = deck.get(i);
            distributions.put(playerName, cardToAssign);
        }
        return distributions;
    }

    public static void main(String[] args) {
        System.out.println(distributeCardsToNPlayer(5));
    }
}
