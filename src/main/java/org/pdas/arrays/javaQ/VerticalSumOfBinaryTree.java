package org.pdas.arrays.javaQ;

import java.util.*;

public class VerticalSumOfBinaryTree {
    //*
    // you are given the root of a binary tree. you have to find the vertical sum of tree
    // vertical sum denotes an array of sum of the different verticals of binary tree, where leftmost vertical sum is the first element of array and rightmost vertical is the last

    // *//

    static class Pair<K, V> {
        private K key;
        private V val;
        public Pair(K key, V val) {
            this.key = key;
            this.val = val;
        }

        public K getKey() {
            return key;
        }

        public V getVal() {
            return val;
        }
    }

    class Node {
        int val;
        Node leftChild;
        Node rightChild;
        Node(int val) {
            this.val = val;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public static List<Integer> verticalSumOfBinaryTree(Node root) {
        // Map to store the horizontal distance and its corresponding sum
        Map<Integer, Integer> verticalSumMap = new HashMap<>();
        // Queue for level order traversal
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<Node, Integer> current = queue.poll();
            Node node = current.getKey();
            int hd = current.getVal();

            if (node != null){
                // update the vertical sum for the current horizontal distance
                verticalSumMap.put(hd, verticalSumMap.getOrDefault(hd, 0)+ node.val);

                // add left child with horizontal distance -1
                queue.offer(new Pair<>(node.leftChild, hd-1));
                // add right child with horizontal distance +1
                queue.add(new Pair<>(node.rightChild, hd+1));
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = Collections.min(verticalSumMap.keySet()); i < Collections.max(verticalSumMap.keySet()); i++){
            result.add(verticalSumMap.getOrDefault(i, 0));
        }
        return result;



    }
}
