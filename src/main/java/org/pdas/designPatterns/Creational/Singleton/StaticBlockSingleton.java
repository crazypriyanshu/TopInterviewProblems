package org.pdas.designPatterns.Creational.Singleton;

public class StaticBlockSingleton {
    private static StaticBlockSingleton instance;
    private StaticBlockSingleton(){}

    // static block
    static {
        try {
            instance = new StaticBlockSingleton();
        } catch (Exception e){
            throw new RuntimeException("Exception encountered");
        }
    }

    // public method to get the instance
    public static StaticBlockSingleton getInstance(){
        return instance;
    }

    // this provides the ability to handle the exceptions during the instance creation

    // the static block is executed when the class is loaded by JVM
    // if exception occurs then its wrapped in RuntimeException


    // it is thread safe but not lazy loaded - which might be a drawback if the initialization is resource intensive
}
