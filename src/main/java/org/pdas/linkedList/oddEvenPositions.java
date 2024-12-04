package org.pdas.linkedList;

public class oddEvenPositions {
    class ListNode{
        public Integer val;
        public ListNode next;
        ListNode(Integer val){
            this.val = val;
            next = null;
        }
    }

    public static ListNode oddEvenProblemMergedList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }

        ListNode odd = head;
        ListNode even = odd.next;
        ListNode evenHead = even;
        while (even != null || even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;
    }

}
