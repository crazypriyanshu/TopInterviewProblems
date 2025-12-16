package org.pdas.designPatterns.Creational.Singleton;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleSingletonClass {
    public static SimpleSingletonClass instance = new SimpleSingletonClass();
    // lets make this a simple singleton class
    private SimpleSingletonClass() {
        System.out.println("Creating Singleton class only once");
    }

    public static SimpleSingletonClass getInstance(){
        // first check
        if (instance == null){
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
            instance = new SimpleSingletonClass();
        }
        return instance;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        Set<Integer> uniqueInstances = new HashSet<>();
        for (int i =0; i < 50; i++) {
            executorService.submit(() -> {
                try {
                    SimpleSingletonClass singletonClassInstance = SimpleSingletonClass.getInstance();
                    synchronized (uniqueInstances) {
                        uniqueInstances.add(singletonClassInstance.hashCode());
                    }
                } catch (Exception e){
                    Thread.currentThread().interrupt();
                } finally {

                }
            });
        }
        executorService.shutdown();

        if (uniqueInstances.size() > 1) {
            System.err.println("!!! SINGLETON FAILURE !!! Multiple instances were created.");
        } else {
            System.out.println("Singleton seemingly succeeded (though this is rare/lucky with this many threads).");
        }
    }

}
