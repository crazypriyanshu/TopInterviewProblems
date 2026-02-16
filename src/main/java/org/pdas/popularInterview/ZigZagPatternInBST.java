package org.pdas.popularInterview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class ZigZagPatternInBST {
    /*
    * You have been given a binary Tree
    * return zig zag order meaning first level left to right and then right to left and so on...
    *
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

    private static ArrayList<ArrayList<Integer>> zigZagPattern(TreeNode A){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null){
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(A);
        boolean rightToLeftTracker = false;

        while(!stack.isEmpty()){
            ArrayList<Integer> currentValues = new ArrayList<>();
            Deque<TreeNode> nextStack = new ArrayDeque<>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                currentValues.add(node.val);
                if (rightToLeftTracker){
                    if (node.right != null) nextStack.push(node.right);
                    if (node.left != null) nextStack.push(node.left);
                } else {
                    if (node.left != null) nextStack.push(node.left);
                    if (node.right != null) nextStack.push(node.right);
                }
            }
            result.add(currentValues);
            stack = nextStack;
            rightToLeftTracker = !rightToLeftTracker;

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        zigZagPattern(node).stream().forEach(System.out::println);
    }
}
