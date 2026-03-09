package org.pdas.trees.binaryTree;

public class LowestCommonAncestor {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }

    /**
     * Given a BST root, and two int B & C, find the lowest common ancestor of B & C
     * Using property of BST, left should be less and right should be bigger
     * */
    private static int findAncestor(TreeNode node, int B, int C){
        if (node.val > B && node.val > C) return findAncestor(node.left, B, C);
        if (node.val < B && node.val < C) return findAncestor(node.right, B, C);
        return node.val;
    }

}
