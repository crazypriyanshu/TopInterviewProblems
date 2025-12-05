package org.pdas.trees.binaryTree;

public class BSTNodesInRange {
    /*
    * Given a binary search tree of integers. You are given a range B and C.
        Return the count of the number of nodes that lie in the given range.
    * */
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static int count = 0;
    public static int solve(TreeNode node, int B, int C){
        count = 0;
        preOrder(node, B, C);
        return count;

    }

    private static void preOrder(TreeNode node, int B, int C){
        if (node == null){
            return;
        }
        if (node.val >= B && node.val <= C){
            count++;
        }
        if (node.val >= B) {
            preOrder(node.left, B, C);
        }
        if (node.val <= C){
            preOrder(node.right, B, C);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(6);
        node.right = new TreeNode(21);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(7);
        System.out.println(solve(node, 2, 20));
    }

}
