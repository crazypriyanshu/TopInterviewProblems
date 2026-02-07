package org.pdas.test;

public class SingletonClass <K,V> {
    String name;
    Integer age;
    //
    private SingletonClass(){

    }

    private SingletonClass instance;

    public SingletonClass getInstance(){
        if (instance == null){
            return new SingletonClass();
        }
        return instance;
    }
}
