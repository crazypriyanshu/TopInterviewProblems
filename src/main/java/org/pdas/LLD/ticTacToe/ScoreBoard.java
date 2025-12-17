package org.pdas.LLD.ticTacToe;

import org.pdas.LLD.ticTacToe.interfaces.GameObserver;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ScoreBoard implements GameObserver {
    private final Map<String, Integer> scores;
    // Track processed Game IDs to prevent double-scoring
    private final Set<String> processedGame = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public ScoreBoard(){
        this.scores = new ConcurrentHashMap<>();
    }
    @Override
    public void update(Game game) {
        // guard against non-winner states
        if (game.getWinner() == null || processedGame.contains(game.getGameId())){
            return;
        }

        if (processedGame.add(game.getGameId())){
            String winnerName = game.getWinner().getName();
            // ATOMIC INCREMENT using merge
            int newScore = scores.merge(winnerName, 1,Integer::sum);
            System.out.printf("[Scoreboard] %s wins! Current total: %d.%n", winnerName, newScore);
        }
    }

    public void printScores(){
        System.out.println("------ Global scoreboard -----------");
        if (scores.isEmpty()){
            System.out.println("No winner declared yet");
            return;
        }
        scores.entrySet().stream()
                .sorted(Map.Entry.<String, Integer> comparingByValue().reversed())
                .forEach( entry -> System.out.printf("Player : %s | Wins :%d%n", entry.getKey(), entry.getValue())
        );
        System.out.println(" -----------------------------------------------");
    }
}
