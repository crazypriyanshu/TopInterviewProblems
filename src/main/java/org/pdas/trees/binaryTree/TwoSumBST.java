package org.pdas.trees.binaryTree;

import java.util.*;

public class TwoSumBST {
    /*
    * Given a binary search tree A, where each node contains a positive integer, and an integer B,
    * you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
    Return 1 to denote that two such nodes exist. Return 0, otherwise.
    * */
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }

    public static int twoSumBST(TreeNode node, int B){
        List<Integer> nodes = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);

        while (!nodeQueue.isEmpty()){
            int sz = nodeQueue.size();
            for (int i=0; i<sz; i++){
                TreeNode front = nodeQueue.poll();
                nodes.add(front.val);

                if (front.left != null){
                    nodeQueue.offer(front.left);
                }
                if (front.right != null){
                    nodeQueue.offer(front.right);
                }
            }
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int i=0; i < nodes.size(); i++){
            int target = B - nodes.get(i);
            if (hashSet.contains(target)){
                return 1;
            }
            hashSet.add(nodes.get(i));
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        System.out.println(twoSumBST(node, 19));
    }

    static Set<Integer> setOfNodes = new HashSet<>();
    long finalSum = 0L;
    long mod = (long) (1e9)+7;
    private int sumCommonNodes(TreeNode A, TreeNode B){
        traverseNodesOfATree(A);
        return traverseNodesOfBTree(B);

    }

    public static void traverseNodesOfATree(TreeNode node){
        if (node != null){
            return;
        }
        setOfNodes.add(node.val);
        traverseNodesOfATree(node.left);
        traverseNodesOfATree(node.right);
    }

    public int traverseNodesOfBTree(TreeNode node){
        if (node == null){
            return 0;
        }
        if (setOfNodes.contains(node.val)){
            finalSum = (finalSum%mod + node.val)%mod;
        }
        traverseNodesOfBTree(node.left);
        traverseNodesOfBTree(node.right);
        return (int)(finalSum%mod);
    }

    public List<Integer> preOrderTraversal(TreeNode node){
        List<Integer> result = new ArrayList<>();
        if (node == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()){
            node = stack.pop();
            result.add(node.val);

            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return result;

    }
}
