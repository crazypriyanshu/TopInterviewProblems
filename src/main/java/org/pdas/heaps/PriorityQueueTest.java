package org.pdas.heaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        minQ.add(3);
        minQ.add(5);
        minQ.add(2);

        System.out.println(minQ + " and poll "+minQ.poll());
        System.out.println(minQ.peek());
        minQ.offer(10);
        System.out.println(minQ.contains(2));

        System.out.println("Present state of maxQ "+ maxQ);
        maxQ.add(10);
        maxQ.offer(20);

        System.out.println("after adding 10, 20 "+ maxQ);
    }
}
