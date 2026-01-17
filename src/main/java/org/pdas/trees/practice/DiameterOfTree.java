package org.pdas.trees.practice;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

// find the diameter of a tree
// length of longest path between 2 nodes
public class DiameterOfTree {
    private static int maxDiameter = 0;

    public static class Tree{
        int val;
        Tree left;
        Tree right;
        Tree(int val){
            this.val = val;
        }
    }

    private static int getMaxDiameter(Tree node){
        calculateDiameter(node);
        return maxDiameter;
    }

    private static int calculateDiameter(Tree node){
        if (node == null){
            return 0; // null node has height  0
        }

        int leftHeight = calculateDiameter(node.left);
        int rightHeight = calculateDiameter(node.right);
        maxDiameter = Math.max(maxDiameter, leftHeight+rightHeight);
        return 1 + leftHeight + rightHeight;
    }

    public static int calculateDiameterBfs(Tree node){
        if (node == null){
            return 0;
        }

        int maxDiameter= 0;
        Map<Tree, Integer> heights = new HashMap<>();
        Queue<Tree> stack = new ArrayDeque<>();
        Tree lastVisited = null;
        Tree current = node;

        while (!stack.isEmpty() || current != null){
            if (current != null){
                stack.offer(current);
                current = current.left;
            } else {
                Tree peekNode = stack.poll();
                // if right child exists, and we are moving from left child, move right
                if (peekNode.right != null && lastVisited != peekNode.right){
                    current = peekNode.right;
                } else {
                    stack.poll();
                    int leftH = heights.getOrDefault(peekNode.left, 0);
                    int rightH = heights.getOrDefault(peekNode.right, 0);
                    maxDiameter = Math.max(maxDiameter, leftH+rightH);
                    heights.put(peekNode, 1+ Math.max(leftH, rightH));
                    lastVisited = peekNode;
                }
            }
        }
        return maxDiameter;
    }

    public static void main(String[] args) {
        Tree node = new Tree(10);
        node.left = new Tree(9);
        node.right = new Tree(11);
        node.left.left = new Tree(8);
        node.left.right = new Tree(9);
        node.left.right.left = new Tree(10);
        node.left.right.left.right = new Tree(12);
//         System.out.println(calculateDiameter(node));
        System.out.println(calculateDiameterBfs(node));
    }
}
