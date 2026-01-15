package org.pdas.trees.practice;

public class PrintNumbers {

    // just to understand function call stacking
    public static void printNumbers(int n){
        if (n == 0){
            return;
        }
        printNumbers(n-1);
        System.out.println(n);

    }

    // prob 2: sum of array of elements using recursion
    // input [1, 2, 3, 4], op- 10
    private static int sumOfArray(int[] arr,int n){
        if (n == 0){
            return 0;
        }
        // return last element + sum of array
        return arr[n-1] + sumOfArray(arr, n-1);

    }

    // find the depth of a tree
    static class Tree{
        int val;
        Tree left;
        Tree right;
        public Tree(int n){
            this.val = n;
        }
    }

    // return the max depth
    public static int maxDepth(Tree node){
        if (node == null){
            return 0;
        }
        int left = maxDepth(node.left); // go left
        int right = maxDepth(node.right); // go right
        return Math.max(left, right)+1; // post traversal

    }

    // binary pre-order traversal
    public static void preOrderTraversal(Tree node){
        // preOrder -> Root -> Left -> Right
        if (node == null){
            System.out.print(" leaf => ");
            return;
        }
        System.out.print(node.val+" => ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);

    }

    // count the leaf nodes
    public static int countLeafNodes(Tree node, int count){
        if (node == null){
            return 0;
        }
        // return 1 only when both left and right subtree is null
        if (node.left == null && node.right == null){
            return 1;
        }
        return countLeafNodes(node.left, count) + countLeafNodes(node.right, count); // finally return sum of both from left and right
    }
    public static void main(String[] args) {
//        printNumbers(5);
//        int[] arr = {1, 2, 3};
//        System.out.println(sumOfArray(arr,arr.length));

        Tree node = new Tree(3);
        node.left = new Tree(1);
        node.right = new Tree(4);

        node.left.right = new Tree(2);

        node.right.right = new Tree(7);
        node.right.left = new Tree(6);
//        System.out.println(maxDepth(node));
//        preOrderTraversal(node);
        System.out.println(countLeafNodes(node, 0));

    }
}
