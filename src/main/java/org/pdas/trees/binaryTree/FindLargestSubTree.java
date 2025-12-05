package org.pdas.trees.binaryTree;

public class FindLargestSubTree {
    /*
    *   You are given a Binary Tree A with N nodes.
        Write a function that returns the size of the largest subtree, which is also a Binary Search Tree (BST).
        If the complete Binary Tree is BST, then return the size of the whole tree.
        NOTE: The largest subtree is the subtree with the most number of nodes.
        *
        * Approach :
        * 1. If we go to each node and find if it's a BST, it will take n^2 time and un necessary computation
        * 2. In top-down approach meaning starting from root node and going layer by layer, we will not be able to count valid BST inside an invalid BST
        * 3. In bottom-top approach - we will be passing range in which subtree was validated to be a valid BST
        *   At each conversion we will analyse the return value and update Stat i.e maxCount and pass either combined values or if any tree is not a valid BST we will pass Data object with valid
        *   BST as false
        *   This parameter will be useful to indicate that all the trees above the discovered invalid bst subtree will also be invalid subtree automatically.
            We will not skip the right subtree in this case as in the right subtree there may be a subtree which could be valid and has more count than currently discovered maxCount.
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

    public static int N = -1;

    public static class Stat {
        int maxCount = 0;
    }

    public static class Data{
        boolean bst = true;
        int[] range;
        int count = 0;
        public Data() {
            range = new int[2];
        }
    }

    public static int solve(TreeNode node){
        Stat s = new Stat();
        traverse(node, s);
        return s.maxCount;
    }

    public static Data traverse(TreeNode node, Stat s){
        if (node == null){
            return new Data();
        }

        Data dataLeft = traverse(node.left, s);
        Data dataRight = traverse(node.right, s);

        // Start the checks
        if (!dataLeft.bst || !dataRight.bst){
            // any of left or right is not BST return
            return dataLeft.bst ? dataRight : dataLeft;
        }
        Data newData = new Data();
        if (dataLeft.count == 0 && dataRight.count == 0){
            // we have hit the leaf node
            dataLeft.range[0] = node.val;
            dataLeft.range[1] = node.val;
            dataLeft.count = 1;
            newData = dataLeft;

        } else if (dataLeft.count ==0 && dataRight.count != 0) {
            // we have only right node for this encounter
            if (node.val < dataRight.range[0]) {
                // it means these are in BST and is in range
                newData.range[0] = node.val;
                newData.range[1] = dataRight.range[1];
                newData.count = dataRight.count+1;
            } else {
                // means it do-not follow the rules of a BST
                newData.bst = false;
                newData.count = 1;
                return newData;
            }

        } else if (dataRight.count == 0 && dataLeft.count != 0) {
                // we have only left node for this encounter
            if (node.val > dataLeft.range[1]) {
                // meaning we are still in BST
                newData.range[0] = dataLeft.range[0];
                newData.range[1] = node.val;
                newData.count = dataLeft.count +1;
            } else {
                newData.bst = false;
                newData.count = 1;
                return newData;
            }
        } else {
            // we have both the nodes left and right node for this encounter
            if (node.val > dataLeft.range[1] && node.val < dataRight.range[0]) {
                newData.range[0] = dataLeft.range[0];
                newData.range[1] = dataRight.range[1];
                newData.count = dataLeft.count + dataRight.count + 1;
            } else {
                newData.bst = false;
                newData.count = 1;
                return newData;
            }
        }

        if (newData.count > s.maxCount){
            s.maxCount = newData.count;
        }
        return newData;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(5);
        node.right = new TreeNode(15);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(8);
        node.right.left = new TreeNode(6);
        node.right.right= new TreeNode(7);

        System.out.println(solve(node));
    }



}
