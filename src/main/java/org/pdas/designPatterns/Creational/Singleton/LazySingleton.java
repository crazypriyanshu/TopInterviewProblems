package org.pdas.designPatterns.Creational.Singleton;

public class LazySingleton {
    // Singleton means that only one instance of this class can be made
    private static LazySingleton instance;

    private LazySingleton(){

    }

    public static LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

    // This singleton is created only when it is needed
}
