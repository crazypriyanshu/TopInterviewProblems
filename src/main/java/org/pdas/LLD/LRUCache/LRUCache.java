package org.pdas.LLD.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> doublyLinkedList;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.doublyLinkedList = new DoublyLinkedList<>();
    }

    public synchronized V get(K key){
        if (!map.containsKey(key)) return null;
        Node<K, V> node = map.get(key);
        doublyLinkedList.moveToFront(node);
        doublyLinkedList.printDoublyLinkedList();
        return node.value;

    }

    public synchronized void put(K key, V value){
        if (map.containsKey(key)){
            Node<K, V> node = map.get(key);
            // for same key if we get same any value, we just update the new value and update DLL
            node.value = value;
            doublyLinkedList.moveToFront(node);
        } else {
            if (map.size() == capacity){
                Node<K, V> lastRecentlyUsedNode = doublyLinkedList.removeLast();
                if (lastRecentlyUsedNode != null) map.remove(lastRecentlyUsedNode.key);
            }
            Node<K, V> newNode = new Node<>(key, value);
            doublyLinkedList.addFirst(newNode);
            map.put(key, newNode);
            doublyLinkedList.printDoublyLinkedList();
        }
    }

    public synchronized void remove(K key){
        if (!map.containsKey(key)) return;
        Node<K, V> node = map.get(key);
        doublyLinkedList.remove(node);
        map.remove(key);
        doublyLinkedList.printDoublyLinkedList();
    }

}
