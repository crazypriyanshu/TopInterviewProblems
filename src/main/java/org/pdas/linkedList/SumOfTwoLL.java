package org.pdas.linkedList;

public class SumOfTwoLL {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode sumOfLL(ListNode A, ListNode B){
        if (A == null || B == null) return null;
        ListNode dummy = new ListNode(-1);
        while (A.next != null && B.next != null){
            int carry = 0;
            int sum = 0;

            if (A.next != null && B.next != null){
                sum = A.val + B.val;
            }

            carry += sum%10;
            dummy.next = new ListNode(sum/10);
        }
        return dummy;
    }

    public static void main(String[] args) {

        ListNode A = new ListNode(2);
        ListNode B = new ListNode(3);
        A.next = new ListNode(4);
        B.next = new ListNode(5);
        sumOfLL(A, B);


    }
}
