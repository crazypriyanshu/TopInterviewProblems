package org.pdas.trees.binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class ZigZagTraversalOfBST {
    /*
    * Given a binary tree, return the zigzag level order traversal of its nodes values.
    * (ie, from left to right, then right to left for the next level and alternate between).
    * */

    public ArrayList<ArrayList<Integer>> zigZagTraversal(TreeNode A){
        // define your ans
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> dq = new ArrayDeque<>();
        // provides a way to use a data structure as both a stack (LIFO - Last-In, First-Out) and a queue (FIFO - First-In, First-Out), and it can efficiently insert and delete elements at both ends
        dq.add(A);
        int count = 0;
        // perform BFS
        while (!dq.isEmpty()){
            int size = dq.size();
            ArrayList<Integer> row = new ArrayList<>();
            for (int i=0; i< size; i++){
                if (count%2 == 0){
                    // even level : move from left to right
                    TreeNode node = dq.removeFirst();
                    if (node.left != null) {
                        dq.addLast(node.left);
                        // add left child to back of deque
                    }
                    if (node.right != null){
                        dq.addLast(node.right);
                        // add right child to back of deque
                    }
                    row.add(node.val);
                } else{
                    // odd level : move right to left
                    TreeNode node = dq.removeLast();
                    if (node.right != null){
                        dq.addFirst(node.right);
                    }
                    if (node.left != null){
                        dq.addFirst(node.left);
                    }
                    row.add(node.val);
                }
            }
            count++;
            ans.add(row);
        }
        return ans;
    }
}
