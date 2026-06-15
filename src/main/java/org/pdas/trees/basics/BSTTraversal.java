package org.pdas.trees.basics;

import org.pdas.a.Some;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * 3 types of traversal:
 * 1. InOrder (Left -> Root -> Right )
 * 2. PreOrder ( Root -> Left -> Right )
 * 3. PostOrder (Root -> Right -> Left )
 * */
public class BSTTraversal {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.left = null;
            this.right = null;
            this.val = val;
        }

        public void insert(int val, TreeNode root){
            if (root == null){
                root.val = val;
            }
            if (root.val > val){

            }
        }
    }

    /**
     * Given a tree, find InOrder traversal
     *  Left -> Root -> Right
     * */
    private static int[] inOrderTraversal(TreeNode root){
        if (root == null) return new int[0];

        Deque<TreeNode> stk = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();

        TreeNode curr = root;
        while (curr !=  null || !stk.isEmpty()){
            // step 1 : reach till the left most node
            while (curr != null){
                stk.push(curr);
                curr = curr.left;
            }
            // curr is null here
            curr = stk.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res.stream().mapToInt(Integer::intValue).toArray();

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(20);
        for (int val: inOrderTraversal(root)){
            System.out.println("val: "+ val);
        }
    }
}
