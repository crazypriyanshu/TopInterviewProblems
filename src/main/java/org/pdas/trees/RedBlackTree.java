package org.pdas.trees;

import org.w3c.dom.Node;

import java.nio.file.Path;

public class RedBlackTree<T extends Comparable<T>> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        T data;
        Node left, right, parent;
        boolean color;

        Node(T data){
            this.data = data;
            this.color = RED; // nodes are initially RED
        }
    }

    private Node root;

    public void insert(T data){
        Node newNode = new Node(data);
        root = bstInsert(root, newNode);

    }

    private Node bstInsert(Node root,Node node){
        if (root == null){
            return node;
        }
        if (root.data.compareTo(root.data) < 0){
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else if (root.data.compareTo(root.data) > 0) {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }
        return root;
    }

    private void fixViolations(Node node){
        Node parent = null, grandparent = null;

        while (node != root && node.color == RED && node.parent.color == RED){
            parent = node.parent;
            grandparent = parent.parent;

            // Case A : Parent is left child of grandparent
            if(parent == grandparent.left){
                Node uncle = grandparent.right;
                // case 1 : if uncle is RED
                if (uncle != null && uncle.color == RED){
                    grandparent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandparent;
                } else {
                    // case 2: node is right child of parent
                    if (node == parent.right){

                    }

                }
            }
        }
    }

    private void rotateLeft(Node node){
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (node.right != null){
            node.right.parent = node;
        }
    }
}
