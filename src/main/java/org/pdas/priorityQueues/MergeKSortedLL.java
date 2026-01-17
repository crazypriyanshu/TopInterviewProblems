package org.pdas.priorityQueues;

import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLL {
    /*
    * Problem: You have k-linked lists, and each one is already sorted in ascending order.
    * Merge them all into one single sorted linked list.
    *
    *   1. Take first node and put in minHeap(comparator)
    *   2. Heap gives smallest node among all nodes
    *   3. remove that node from the list and add to result list
    *   4. after removing take next node and remove from list i and put into heap
    *   5. repeat until heap is empty
    *
    * */

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    private static ListNode mergeKSortedLinkedList(ListNode[] nodes){
        if (nodes == null || nodes.length == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)-> a.val- b.val);

        // initialize heap with head of list
        for (ListNode node: nodes){
            if (node != null){
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // process the heap now
        while (!pq.isEmpty()){
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;
            if (smallest.next != null){
                pq.add(smallest.next);
            }
        }
        return dummy.next;


    }

    public static void main(String[] args) {
        ListNode node = new ListNode(10);
        node.next = new ListNode(15);
        node.next.next = new ListNode(20);

        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(8);
        node1.next.next = new ListNode(11);

        ListNode node2 = new ListNode(3);
        node2.next = new ListNode(14);
        node2.next.next = new ListNode(25);

        ListNode[] nodes = {node, node1, node2};
        printLL(mergeKSortedLinkedList(nodes));


    }
    private static void printLL(ListNode node){
        while (node.next != null){
            System.out.print("  "+node.val+ " => ");
            node = node.next;
        }
    }
}
