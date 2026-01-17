package org.pdas.trees.practice;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class HeightOfTree {

    static class Tree{
        int val;
        Tree left;
        Tree right;
        Tree(int val){
            this.val = val;
        }
    }

    /*
    * Height of the tree : How to find ?
    * We can calculate the length of root to leaf - this is height
    * we just need to find the max height
    * */

    public static int dfs(Tree node){
        if (node == null){
            return -1;
        }
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);
        return 1+Math.max(leftHeight, rightHeight);
    }

    public static int bfs(Tree node){
        if (node == null){
            return -1;
        }

        Queue<Tree> queue = new ArrayDeque<>();
        queue.offer(node);
        int height = -1;
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            height++;
            for (int i = 0; i < levelSize; i++) {
                Tree currNode = queue.poll();
                if (currNode.left!= null) queue.offer(currNode.left);
                if (currNode.right != null) queue.offer(currNode.right);
            }
        }
        return height;
    }

    public static void main(String[] args) {
        Tree node = new Tree(5);
        node.left = new Tree(4);
        node.right = new Tree(7);
        node.left.left = new Tree(2);
        node.left.left.right = new Tree(1);
        node.left.left.right.left = new Tree(10);

        System.out.println(bfs(node));
    }
}
