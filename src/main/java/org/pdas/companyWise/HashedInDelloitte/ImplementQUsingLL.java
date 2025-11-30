package org.pdas.companyWise.HashedInDelloitte;


import java.util.Queue;

// How do you implement a queue using a linked list?
public class ImplementQUsingLL {
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    static class Queue{
        Node front, rear;
        public Queue(){
            front = rear = null;
        }

        // add element to queue\
        void enqueue(int x){
            Node temp = new Node(x);
            // if queue is empty
            if (rear == null){
                front = rear = temp;
                return;
            }
            // add new node at the end
            rear.next = temp;
            rear = temp;
        }

        // remove an element from queue
        int dequeue(){
            if (front == null){
                System.out.println("Queue is empty");
                return -1;
            }
            int val = front.data;
            front = front.next;
            // if queue becomes empty
            if (front == null){
                rear = null;
            }
            return val;
        }

        int peek(){
            if (front == null){
                System.out.println("Queue is empty");
                return -1;
            }
            return front.data;
        }

        boolean isEmpty(){
            return front == null;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.dequeue()); // 10
        System.out.println(q.peek());    // 20
        System.out.println(q.isEmpty()); // false
    }
}
