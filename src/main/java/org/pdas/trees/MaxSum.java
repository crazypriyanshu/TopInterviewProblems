package org.pdas.trees;

public class MaxSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    int maxSum = Integer.MIN_VALUE/2;

    public int maxPathSum(TreeNode node){
        maxGain(node);
        return maxSum;

    }

    private int maxGain(TreeNode node){
        if (node == null){
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);
        int currPathSum = node.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, currPathSum);
        return node.val+Math.max(leftGain, rightGain);
    }
}
