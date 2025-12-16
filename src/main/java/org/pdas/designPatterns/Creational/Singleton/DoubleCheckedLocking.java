package org.pdas.designPatterns.Creational.Singleton;

public class DoubleCheckedLocking {
    // this approach minimises the performance overhead from synchronizing when the object is created
    // we would use the volatile keyword to ensure that the instance variables are immediately visible to threads
    private static volatile DoubleCheckedLocking instance;

    private DoubleCheckedLocking(){

    }

    public static DoubleCheckedLocking getInstance(){
        // first check - not synchronized
        // if the first check passes, then we would synchronize the class object
        if (instance == null){
            // synchronize the class object
            synchronized (DoubleCheckedLocking.class){
                // second check - synchronized
                // this second check is multiple thread would have passed the first check if many threads tried creating this object all at once
                if (instance == null){
                    // create the instance only if the both check would have passed
                    instance = new DoubleCheckedLocking();
                }
            }
        }
        return instance;
    }
}
