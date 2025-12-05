package org.pdas.trees.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class IdenticalBinaryTree {
    /*
    * Given two binary trees, check if they are equal or not.
        Rule : Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
    * */

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static int isSameBST(TreeNode A, TreeNode B){

        return isEqual(A, B) ? 1: 0;


    }

    public static boolean isEqual(TreeNode A, TreeNode B){
        if (A == null && B == null){
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        q.add(B);
        while (!q.isEmpty()){
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();

            if(t1 == null && t2 == null){
                // not yet decided
                continue;
            } else if (t1 == null || t2 == null) {
                // meaning either of them is null
                return false;
            }
            if (t1.val != t2.val){
                return false;
            }
            q.add(t1.left);
            q.add(t2.left);

            q.add(t1.right);
            q.add(t2.right);

        }
        return true;
    }

    private static boolean inOrder(TreeNode A, TreeNode B){
        if (A == null && B == null){
            return true;
        }
        if (A == null || B == null){
            return false;
        }
        boolean first = inOrder(A.left, B.left);
        if (A.val != B.val){
            return false;
        }
        boolean second = inOrder(A.right, B.right);
        return first && second;
    }

    private static boolean preOrder(TreeNode A, TreeNode B){
        if (A == null && B == null){
            return true;
        }
        if (A == null || B == null){
            return false;
        }
        if (A.val != B.val){
            return false;
        }
        boolean first = preOrder(A.left, B.left);
        boolean second = preOrder(A.right, B.right);
        return first && second;
    }

    private static boolean postOrder(TreeNode A, TreeNode B){
        if (A == null && B == null){
            return true;
        }
        if (A == null || B == null){
            return false;
        }

        boolean first = postOrder(A.left, B.left);
        boolean second = postOrder(A.right, B.right);
        return first && second && A.val == B.val;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(2);
        TreeNode B = new TreeNode(2);

        A.left = new TreeNode(1);
        A.right = new TreeNode(3);

        B.left = new TreeNode(1);
        B.right = new TreeNode(3);

        System.out.println(isSameBST(A, B));
    }
}
