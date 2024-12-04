package org.pdas.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> numbers = new PriorityQueue<>(Collections.reverseOrder());
        numbers.add(4);
        numbers.add(2);
        numbers.add(1);
        numbers.add(5);

        System.out.println("Priority Q "+ numbers);
        int head = numbers.peek();
        System.out.println("Head of Q "+head);
        int polled = numbers.poll();
        System.out.println("Polled number "+ polled);
        System.out.println("After polling the priority Q "+numbers);

        numbers.offer(8);
        System.out.println(numbers);

    }
}
