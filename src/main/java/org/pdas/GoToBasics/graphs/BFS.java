package org.pdas.GoToBasics.graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
* This class is responsible for implementing methods for a BFS
* connect method has a logic of how for a tree like data structure where a node has data and left and right node
*
* */
public class BFS  implements TreeConnectionStrategy{
    @Override
    public void connect(PNode root) {
        PNode tempNode;
        // So we get a root node, first we check if the node is not empty, if its empty, we just return
        if (root == null){
            return;
        }
        // created a Queue data structure, which would store the nodes once we find
        Queue<PNode> bfsList = new LinkedList<>();
        bfsList.add(root);

        while (!bfsList.isEmpty()) {
            tempNode = bfsList.poll();
            System.out.println(tempNode+" ==>  ");
            if (tempNode.left != null){
                bfsList.add(tempNode.left);
            }
            if (tempNode.right != null){
                bfsList.add(tempNode.right);
            }
        }

    }
}
