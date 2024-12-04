package org.pdas.arrays.javaQ;

public class MyRunnable implements Runnable{
    public static int counter = 0;
    @Override
    public void run() {
        for (int i=0; i< 100000; i++){
            counter++;
        }
    }
}
