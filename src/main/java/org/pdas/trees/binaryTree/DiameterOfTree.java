package org.pdas.trees.binaryTree;

public class DiameterOfTree {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.right = null;
            this.left = null;
        }
    }

    private static int maxDiameter = 0;
    /**
     * find the diameter of a tree
     * longest length between any two nodes
     * */
    private static int findDiameter(TreeNode root){
        if (root == null) return 0;
        int leftHeight = findDiameter(root.left);
        int rightHeight = findDiameter(root.right);

        maxDiameter = Math.max(maxDiameter, leftHeight+rightHeight);
        return Math.max(leftHeight, rightHeight)+1;

    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(3);
        node.right = new TreeNode(10);

//        node.left.left = new TreeNode(3);
//        node.left.right = new TreeNode(6);

        System.out.println(findDiameter(node));
    }
}
