package org.pdas.LLD.LRUCache;

public class DoublyLinkedList<K, V> {
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public DoublyLinkedList() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.prev = head;
    }


    public void addFirst(Node<K,V> node){
        // Make node's next should point to head's next
        node.next = head.next;
        // Make node's prev should point to head, head remains as is
        node.prev = head;
        // also tail.prev = node
        tail.prev = node;
        // make head.next = node
        head.next = node;
        System.out.println("Added to start of LL: "+node.key);
    }

    public void remove(Node<K, V> node){
        // if i have to remove the node, i have to update the pointers of
        // node.prev.next(node before this next value should point to node.next and
        // node.next.prev(node after this prev value should point to node.prev
        node.prev.next = node.next;
        node.next.prev = node.prev;
        System.out.println("Removing key: "+node.key);
    }

    public void moveToFront(Node<K, V> node){
        remove(node);
        addFirst(node);
        System.out.println("Move to front : "+node.key);
    }

    public Node<K, V> removeLast(){
        if (tail.prev == head) return null;
        // last node in doubly linked list would be the one tail.prev
        Node<K, V> lastNode = tail.prev;
        // remove - we remove by making node.next.prev = node.prev and node.prev.next = node.next
        remove(lastNode);
        System.out.println("Removing last "+lastNode.key);
        return lastNode;
    }

    public void printDoublyLinkedList(){
        Node node = head;
        System.out.println("-------------- Printing DLL start to end ----------- ");
        while (node.next != null){
            if (node.value == null) {
                System.out.print("HEAD");
            }
            else { System.out.print(" => "+node.key);}
            node = node.next;
        }
        System.out.println();

    }

    private void printDLLBackward(){
        Node back = tail;
        System.out.println(" ------------- Printing DLL backwards -------------");
        while (back.prev != null){
            if (back.value == null) {
                System.out.print("TAIL ");
            }
            else { System.out.print(" => "+back.key); }
            back = back.prev;
        }
        System.out.println();
    }
}
