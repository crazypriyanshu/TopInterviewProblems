package org.pdas.designPatterns.Creational.Singleton;

public class BillPughSingleton {
    // this implementation uses a static helper class to hold singleton instance.
    // The inner class is not loaded to memory until it is referenced for the first time in the getInstance() method
    // this becomes thread safe without requiring explicit synchronization
    private BillPughSingleton(){}

    private static class SingletonHelper{
        private static final BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return SingletonHelper.instance;
    }

    // when getInstance method is called for the first time, it triggers loading of the helper class
    // when inner class(SingletonHelper) is loaded - it creates the instance of BillPughSingleton
    // final keyword makes sure that instance can't be reinitialized

    // This basically provides a well-balanced of lazy initialization , thread safety, performance, without any complexities of double-checked locking

}
