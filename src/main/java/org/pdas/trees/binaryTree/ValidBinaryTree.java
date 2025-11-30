package org.pdas.trees.binaryTree;
/*
* Problem : You are given a binary tree represented by root A.
You need to check if it is a Binary Search Tree or not.

Assume a BST is defined as follows:

1) The left subtree of a node contains only nodes with keys less than the node's key.

2) The right subtree of a node contains only nodes with keys greater than the node's key.

3) Both the left and right subtrees must also be binary search trees.
* */

public class ValidBinaryTree {
    public int prev = Integer.MIN_VALUE;

    class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(int x){
            val = x;
        }
    }

    public boolean validateBST(TreeNode node, int min, int max) {

        if (node == null){
            return true;
        }
        if (node.val <= min || node.val >= max){
            return false;
        }
        return validateBST(node.left, min, node.val) && validateBST(node.right, node.val, max);
    }

    public int isValidBST(TreeNode node){
        if(node == null){
            return 1;
        }
        int val = 1;
        if (node.left != null){
            val = isValidBST(node.left);
        }
        if (node.val<this.prev || val == 0){
            // if curr node < inorder predecessor or left subtree returned 0
            return 0;
        }
        this.prev = node.val;
        return isValidBST(node.right);
    }

}
