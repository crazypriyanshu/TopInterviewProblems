package org.pdas;

public class MyClass {
    static int x = 10;

    public static void main(String[] args) {
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();
        obj1.x = 20;
        System.out.println(obj1.x+ " "+ obj2.x);
        obj1.display();
    }

    static void display(){
        System.out.println(" UUU");
    }
}
