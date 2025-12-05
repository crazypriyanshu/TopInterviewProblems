package org.pdas.companyWise.Salesforce;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    private final int capacity;
    public static class Node{
        int key, value, freq;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }
    private int minFreq;
    private Map<Integer, Node> nodeMap;
    private Map<Integer, LinkedHashSet<Node>> freqMap;

    public LFUCache(int capacity){
        this.capacity = capacity;
        this.minFreq = 0;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key){
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        updateFreq(node);
        return node.value;
    }

    private void updateFreq(Node node){
        int oldFreq = node.freq;
        LinkedHashSet<Node> oldList = freqMap.get(oldFreq);
    }

}
