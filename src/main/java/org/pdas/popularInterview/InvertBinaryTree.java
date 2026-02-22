package org.pdas.popularInterview;

import java.util.ArrayList;
import java.util.Comparator;

public class InvertBinaryTree {
    /*
    * You are given a binary tree containing n nodes
    * you have to invert a tree whne both children are smaller i.e swap left and right subtree
    * if both are smaller then swap left and right
    * take the values of null nodes as 0
    * */

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }

    }

    private static TreeNode dfs(TreeNode root){
        if (root == null){
            return null;
        }

        if (root.left == null && root.right == null){
            return root;
        }

        if (root.left != null && root.right != null){
            if (root.val < root.left.val && root.val < root.right.val){
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
        }

        dfs(root.left);
        dfs(root.right);
        return root;
    }

    public static void printTree(TreeNode root){
        if (root == null) return;
        System.out.println("Root: "+root.val);
        System.out.println("----------");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(10);
        a.left = new TreeNode(4);
        a.right = new TreeNode(7);
        System.out.println("Before ");
        printTree(a);

        TreeNode ans = dfs(a);
        System.out.println("After: ");
        printTree(a);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(a.val);

        res.add(a.left.val);
        res.stream().sorted();


    }
}
