package org.pdas.trees.basics;

import lombok.val;

import java.util.*;
import java.util.function.Consumer;

public class BST<T extends Comparable<T>> {

    private class Node<T> {
        T val;
        Node left, right;
        Node(T val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size = 0;

    /**
     * Inserts a value to BST
     * Duplicates are not allowed
     * @param value : value to be inserted - can't be null
     * @return true if value was inserted, false if already exists
     * @throws IllegalArgumentException if the val is null
     * */
    public boolean insert(T value){
        if (value == null) throw new IllegalArgumentException("Null values can't be inserted in the ");

        if (contains(value)){
            return false;
        }

        root = insertRecord(root, value);
        size++;
        return true;
    }

    private Node<T> insertRecord(Node<T> root, T value) {
        if (root == null) return new Node<>(value);

        int comp = value.compareTo(root.val);
        if (comp < 0) {
            root.left = insertRecord(root.left, value);
        }
        if (comp > 0) {
            root.right = insertRecord(root.right, value);
        }
        return root;
    }


    public boolean contains(T val){
        return containsRecord(root, val);
   }

   private boolean containsRecord(Node<T> node, T val){
        if (node == null){
            return false;
        }

        int cmp = val.compareTo(node.val);
        if (cmp < 0) return containsRecord(node.left, val);
        if (cmp > 0) return containsRecord(node.right, val);
        return true;
   }

   public boolean delete(T value){
        if (!contains(value)) return false;

        root = deleteRecord(root, value);
        size--;
        return true;
   }

    private Node<T> deleteRecord(Node<T> root, T value) {
        if (root == null) return null;
        int cmp = value.compareTo(root.val);
        if (cmp < 0) {
            root.left = deleteRecord(root.left, value);
        } else if (cmp > 0){
            root.right = deleteRecord(root.right, value);
        } else {
            // node to be deleted found
            // case 1: no child or one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // case 2 : two child - find inOrder successor

            Node<T> successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteRecord(root.right, successor.val);
        }
        return root;
    }

    private Node<T> findMin(Node<T> node) {
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public int size() {
        return size;
    }

    private int heightRec(Node<T> root){
        if (root == null) return 0;
        return 1 + Math.max(heightRec(root.left), heightRec(root.right));
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isBalanced(){
        return isBalancedRec(root);
    }

    private boolean isBalancedRec(Node<T> root) {
        if (root == null){
            return true;
        }

        int leftHeight =heightRec(root.left);
        int rightHeight = heightRec(root.right);

        return Math.abs(leftHeight - rightHeight) <= 1 &&
                isBalancedRec(root.left) &&
                isBalancedRec(root.right);
    }

    public void printInOrder(){
        printInOrderRec(root);
        System.out.println();
    }

    private void printInOrderRec(Node<T> root) {
        if(root == null) return;
        printInOrderRec(root.left);
        System.out.print(root.val+" => ");
        printInOrderRec(root.right);
    }

    /**
     * preOrder -> root -> left -> right
     *
     * */
    public void printLevelOrder(){
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        Deque<Node<T>> stk = new ArrayDeque<>();
        stk.push(root);
        while (!stk.isEmpty()){
            Node<T> curr = stk.pop();
            System.out.print(curr.val + " => ");
            if (curr.left != null) stk.push(curr.left);
            if (curr.right != null) stk.push(curr.right);
        }
        System.out.println();
    }

    /**
     * root -> left -> right
     * */
    public void printPreOrderTraversal(){

        if(Objects.isNull(root)){
            throw new IllegalStateException("Root is null");
        }

        Deque<Node> stack = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();

        stack.push(root);
    }

}
