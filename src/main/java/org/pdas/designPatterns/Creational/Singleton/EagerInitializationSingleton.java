package org.pdas.designPatterns.Creational.Singleton;

public class EagerInitializationSingleton {

    // The single instance, created immediately, the final keyword prevents reassignment after initialization
    private static final EagerInitializationSingleton instance = new EagerInitializationSingleton();
    private EagerInitializationSingleton(){

    }

    // suitable : if app always creates and uses singleton instance or the overhead of creating it is minimal

    public static EagerInitializationSingleton getInstance(){
        return instance;
    }

    // while this way is thread safe,
    // it could potentially waste resources if the singleton instance is never used by client application
}
