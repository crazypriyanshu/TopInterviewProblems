package org.pdas.trees.binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTraversal {


    public static ArrayList<Integer> preOrder(TreeNode node){
        ArrayList<Integer> list = new ArrayList<>();
        if (node == null){
            return list;
        }
        list.add(node.val);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            node = stack.pop();
            list.add(node.val);
            if (node.right != null){
                stack.push(node.right);
            } if (node.left != null){
                stack.push(node.left);
            }
        }
        return list;
    }
}
