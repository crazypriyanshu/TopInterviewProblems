package org.pdas.Threads;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    static Map<String, LocalDateTime> map;
    static StringBuilder critical = new StringBuilder();
    static AtomicString criticalString;


    StampedLockDemo(Map<String, LocalDateTime> map){
        this.map = map;
    }

    StampedLock lock = new StampedLock();

    public void put(String key){
        Long stamp = lock.writeLock();
        try {
            System.out.println("Putting "+ key);
            map.put(key, LocalDateTime.now());
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public void get(String key){
        Long stamp = lock.readLock();
        try {
            LocalDateTime ans = map.get(key);
            if (ans == null){
                System.out.println("No value not in Map, map is Empty!!");
            }else {
                System.out.println("** Value in Map ** "+ans.toString());
            }

        } finally {
            lock.unlockRead(stamp);
        }
    }

    public static String generateNewString() {
        int leftLimit = 41;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        String ans = random.ints(leftLimit, rightLimit+1)
                .filter(i -> (i <= 57 || i > 65) && (i <=90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return ans;
    }

    public static Runnable createTaskType1(HashMap<String, LocalDateTime> synceHashMap){
        return new Runnable() {
            StampedLockDemo obj = new StampedLockDemo(synceHashMap);
            @Override
            public void run() {
                    String val = generateNewString();
                    try {
                        critical.append(val);
                        criticalString.put(val);

                        System.out.println("Thread is going to add value in map: "+ val);
                        System.out.println("By ThreadName : "+ Thread.currentThread().getName());
                        obj.put(val);
                    }finally {

                        int start = critical.lastIndexOf(val);
                        if (start != -1){
                            critical.delete(start, start+val.length());
                        }
                    }

            }


        };
    }

    public static Runnable createTaskType2(HashMap<String, LocalDateTime> synceHashMap){
        return new Runnable() {
            StampedLockDemo obj = new StampedLockDemo(synceHashMap);
            @Override
            public void run() {
                System.out.println("Thread is going to read value of map: "+ critical);
                System.out.println("ThreadName : "+ Thread.currentThread().getName());
                obj.get(critical.toString());

            }
        };
    }

    public static void main(String[] args) {
        HashMap<String, LocalDateTime> synceHashMap = new HashMap<>();



        Runnable task1 = createTaskType1(synceHashMap);
        Runnable task2 = createTaskType1(synceHashMap);
        Runnable task3 = createTaskType1(synceHashMap);
        Runnable task4 = createTaskType2(synceHashMap);
        Runnable task5 = createTaskType2(synceHashMap);
        Runnable task6 = createTaskType2(synceHashMap);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
        Thread t4 = new Thread(task4);
        Thread t5 = new Thread(task5);
        Thread t6 = new Thread(task6);
        Thread t7 = new Thread(task1);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();





    }
}
