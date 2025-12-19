package org.pdas.LLD.LRUCache;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);
        lruCache.put("cat", 1);
        lruCache.put("dog", 2);
        lruCache.put("cow", 3);
        lruCache.put("human", 4);


        lruCache.put("pigeon", 5);
        System.out.println(lruCache.get("human"));

    }
}
