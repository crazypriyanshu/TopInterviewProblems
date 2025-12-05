package org.pdas.trees.binaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTraversal {


    static ArrayList<Integer> ans = new ArrayList<>();
    public static ArrayList<Integer> postOrderTraversal(TreeNode A){

        if (A == null) {
            return ans;
        }
        postOrderTraversal(A.left);
        postOrderTraversal(A.right);
        ans.add(A.val);

        return ans;
    }

        ArrayList<Integer> ans1 = new ArrayList<Integer>();

        public ArrayList<Integer> postorderTraversal(TreeNode A) {
            if(A==null){
                return ans1;
            }
            postorderTraversal(A.left);
            postorderTraversal(A.right);
            ans1.add(A.val);
            return ans1;

        }

        public ArrayList<Integer> postOrderTraversal1(TreeNode A){
            Stack<TreeNode> stack1, stack2;
            ArrayList<Integer> postOrder;

            TreeNode node;
            stack1 = new Stack<>();
            stack2 = new Stack<>();
            postOrder = new ArrayList<>();


            if (A == null){
                return postOrder;
            }
            stack1.push(A);
            while (!stack1.isEmpty()){
                node = stack1.pop();
                stack2.push(node);
                if (node.left != null){
                    stack1.push(node.left);
                }
                if (node.right != null){
                    stack1.push(node.right);
                }
            }
            while (!stack2.isEmpty()){
                node = stack2.pop();
                postOrder.add(node.val);
            }

            return postOrder;
        }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        System.out.println(postOrderTraversal(treeNode));
    }
}
