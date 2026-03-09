package org.pdas.trees.binaryTree;

public class FlattenBinaryTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left= null;
            this.right = null;
        }
    }

    static TreeNode prev = null;
    private static void flatten(TreeNode node){
        if (node == null) return;

        flatten(node.right);
        flatten(node.left);

        node.right = prev;
        node.left = null;
        prev = node;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.right = new TreeNode(5);
        A.left = new TreeNode(2);

        A.left.left = new TreeNode(3);
        A.left.right = new TreeNode(4);

        A.right.right = new TreeNode(6);
        A.right.right.left = new TreeNode(7);

        flatten(A);
    }
}
