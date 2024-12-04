package org.pdas;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyClass {
    static int x = 10;

    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();
        obj1.x = 20;
        System.out.println(obj1.x+ " "+ obj2.x);
        obj1.display();
        Queue<Integer> priorityQue = new PriorityQueue<>();
        priorityQue.add(7);
        priorityQue.add(2);
        priorityQue.add(90);
        System.out.println(priorityQue);

        Queue<Integer> q2 = new ArrayDeque<>();
        q2.add(170);
        q2.add(30);
        q2.add(120);
        System.out.println(q2);
        System.out.println(q2.peek());
    }

    static void display(){
        System.out.println(" UUU");
    }
}
