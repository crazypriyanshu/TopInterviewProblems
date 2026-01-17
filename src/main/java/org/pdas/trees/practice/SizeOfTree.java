package org.pdas.trees.practice;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class SizeOfTree {

    /*
    * Size(node) = 1 + Size(node.left) + Size(node.right)
    * */

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    // recursive - dfs approach
    public static int calculateSizeDfs(TreeNode node){
        if (node == null){
            return 0;
        }
        return 1+calculateSizeDfs(node.left)+calculateSizeDfs(node.right);
    }

    // iterative approach
    public static int calculateSizeBfs(TreeNode node){
        if (node == null){
            return 0;
        }

        int count = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode currNode = queue.poll();
            count++;
            if (currNode.left != null){
                queue.offer(currNode.left);
            }
            if (currNode.right != null){
                queue.offer(currNode.right);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(5);
        node.right = new TreeNode(10);
        node.left.left = new TreeNode(3);
        // System.out.println(calculateSizeDfs(node));
        System.out.println(calculateSizeBfs(node));
    }
}
