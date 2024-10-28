package org.pdas.Threads;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicString {
    private AtomicReference<String> atomicString = new AtomicReference<>("initialValue");

    public  void put(String val){
        atomicString.set(val);
    }
    public String get(){
        return atomicString.get();
    }

    public boolean compareAndSet(String expectedValue, String newValue){
        return atomicString.compareAndSet(expectedValue, newValue);

    }
}
