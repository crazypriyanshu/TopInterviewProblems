package org.pdas.trees.binaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBinaryTree {
    /*
    * Two elements of a Binary Search Tree (BST), represented by root A are swapped by mistake.
    *  Tell us the 2 values, when swapped, will restore the Binary Search Tree (BST).
        A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
        Note: The 2 values must be returned in ascending order
    * */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> recoverBST(TreeNode node){
        // pointer for 2 swapped nodes
        TreeNode first = null;
        TreeNode second = null;

        // pointer to track the previously visited node inOrder
        TreeNode previous = null;

        // pointers for Morris traversal
        TreeNode current = node;
        TreeNode predecessor = null;

        while (current != null){
            if (current.left == null){
                // Case 1.true: No left subtree or already processed
                // InOrder processing
                if (previous != null && previous.val > current.val) {
                    // if first is null then this is going to be the first violation
                    if (first == null){
                        first = previous;
                    }
                    // second is always current node
                    second = current;
                }
                previous = current; // update the previous node
                // move to right
                current = current.right;
            } else {
                // Case 1.false: Left subtree exists
                // find predecessor = right most node in left subtree
                predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current){
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null){
                    // create a thread
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // thread already exists - meaning left subtree is already processed
                    // check for BST violation
                    if (previous != null && previous.val > current.val){
                        if (first == null){
                            first = previous;
                        }
                        // 'second' will be updated to the currently 'small' node
                        second = current;
                    }
                    previous = current; // update the previous node
                    // destroy the thread
                    predecessor.right = null;
                    current = current.right;

                }
            }
        }
        List<Integer> result = new ArrayList<>();
        result.add(first.val);
        result.add(second.val);
        Collections.sort(result);
        return result;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        recoverBST(node);
    }

}
