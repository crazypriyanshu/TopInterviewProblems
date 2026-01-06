package org.pdas.lruCache;

import lombok.RequiredArgsConstructor;
import org.pdas.LLD.LRUCache.DoublyLinkedList;
import org.pdas.LLD.LRUCache.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;


public class LRUCache<K, V> {
    private final int capacity;
    private final Map<K, Node<K, V>> map;
    private final DoublyLinkedList<K, V> list;
    private final ReentrantLock lock = new ReentrantLock();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.list = new DoublyLinkedList<>();
    }

    public V get(K key){
        lock.lock();
        try {
            if (!map.containsKey(key)){
                return null;
            }
            else {
                Node<K, V> node = map.get(key);
                list.addFirst(node);
                return node.getValue();
            }
        } finally {
            lock.unlock();
        }
    }

    public void put(Node<K, V> node){
        lock.lock();
        try {
            if (map.containsKey(node.getKey())){
                map.put(node.getKey(), node);
                list.addFirst(node);
            } else {
                if (map.size() >= capacity){
                    Node<K,V> lastNode =list.removeLast();
                    map.remove(lastNode.getKey());
                }
                Node<K, V> newNode = new Node<K, V>(node.getKey(), node.getValue());
                list.addFirst(newNode);
            }
        } finally {
            lock.unlock();
        }
    }

}
