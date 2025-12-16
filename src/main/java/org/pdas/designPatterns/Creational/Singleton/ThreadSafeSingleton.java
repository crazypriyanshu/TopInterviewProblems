package org.pdas.designPatterns.Creational.Singleton;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){

    }


    // with synchronized - only one thread can enter this thread at a time
    // when thread enter synchronized method it acquires lock on the class objects
    // other threads have to wait to enter this synchronized method
    public static synchronized ThreadSafeSingleton getInstance(){
        if (instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
    // cons : although this approach is staright forward using synchronized can cause substantial over-head and reduce the performance
    // this can be a bottleneck when called frequently
}
