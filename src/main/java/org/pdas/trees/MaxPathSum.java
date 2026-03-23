package org.pdas.trees;

public class MaxPathSum {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    private static int findMaxSum(Node root){
        if (root == null) return 0;
        return maxSumPassingThroughRoot(root);
    }

    private static int maxSumPassingThroughRoot(Node root){
        if (root == null) return 0;
        int left = maxSumPassingThroughRoot(root.left);
        int right = maxSumPassingThroughRoot(root.right);
        int val = root.val + Math.max(0, left) + Math.max(0, right);
        return val;
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(3);
        root.right = new Node(26);

        root.left.right = new Node(3);
        root.left.right.left = new Node(1);

        root.right.left = new Node(18);
        root.right.right = new Node(22);

        System.out.println(maxSumPassingThroughRoot(root));


    }
}
