package org.pdas.a;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class Some {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(20);
        for (int val: postOrder(root)){
            System.out.println("val: "+ val);
        }
    }

    private static int[] inOrder(TreeNode A){
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new ArrayDeque<>();
        TreeNode curr = A;
        while (curr != null || !stk.isEmpty()){
            while (curr != null){
                stk.push(curr);
                curr = curr.left;
            }
            curr = stk.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     *
     * Left -> Right -> Root
     * */
    private static int[] postOrder(TreeNode A){
        if (A == null){
            return new int[0];
        }

        ArrayDeque<TreeNode> stk = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode curr = A;
        TreeNode lastVisited = null;

        while (curr != null || !stk.isEmpty()){
            // go as deep left as possible
            while (curr != null){
                stk.push(curr);
                curr = curr.left;
            }
            // peek to the node
            TreeNode peekNode = stk.peek();
            if (peekNode.right != null && lastVisited != peekNode.right){
                curr = peekNode.right;
            } else {
                res.add(peekNode.val);
                lastVisited = stk.pop();
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
