package org.pdas.Threads;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockAPIDemo {
    private HashMap<String, String> syncedStorage;
    ReadWriteLock lock = new ReentrantReadWriteLock();

    private LockAPIDemo(HashMap<String, String> syncedStorage) {
        this.syncedStorage = syncedStorage;
    }

    Lock writeLock = lock.writeLock();


    public void put(String key, String value) {
        try {
            writeLock.lock();
            System.out.println("Putting "+ key + " with value "+ value);
            syncedStorage.put(key, value);
        }
        finally {
            writeLock.unlock();
        }
    }

    public void remove(String key){
        try {
            writeLock.lock();

            syncedStorage.remove(key);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            writeLock.unlock();
        }
    }

    Lock readLock = lock.readLock();

    public void get(String key){
        try{
            readLock.lock();
            syncedStorage.get(key);
        }
        finally {
            readLock.unlock();
        }

    }

    public boolean containsKey(String key){
        try {
            readLock.lock();
            return syncedStorage.containsKey(key);
        }
        finally {
            readLock.unlock();
        }
    }

    public static String generateNewRandomString(){
        int leftLimit = 41;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit+1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        LockAPIDemo synchedMap = new LockAPIDemo(map);
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Trying to add value in map");
                synchedMap.put(generateNewRandomString(), "threadTask1");

            }
        };
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Trying to add value in map");
                synchedMap.put(generateNewRandomString(), "threadTask2");

            }
        };

        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Trying to add value in map");
                synchedMap.put(generateNewRandomString(), "threadTask3");

            }
        };

        Thread thread1Task1 = new Thread(task1);
        Thread thread1Task2 = new Thread(task2);
        Thread thread1Task3 = new Thread(task3);
        thread1Task3.start();
        thread1Task1.start();
        thread1Task2.start();

        for (int i= 0; i< 1000; i++){
            int finalI = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("Trying to add value in map "+ Thread.currentThread().getName());
                    synchedMap.put(generateNewRandomString(), "threadTask"+ finalI);

                }
            };
            Thread thread = new Thread(task);
            thread.start();

        }





    }
}
