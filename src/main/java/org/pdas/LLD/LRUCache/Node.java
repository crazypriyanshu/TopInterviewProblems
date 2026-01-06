package org.pdas.LLD.LRUCache;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<K, V> {
    K key;
    V value;

    Node<K,V> prev, next;
    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }
}
