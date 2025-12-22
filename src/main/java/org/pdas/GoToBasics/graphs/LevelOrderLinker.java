package org.pdas.GoToBasics.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderLinker implements TreeConnectionStrategy{
    @Override
    public void connect(PNode root) {
        if (root == null) return;
        Queue<PNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            PNode previousInLevel = null;
            for (int i = 0; i < levelSize; i++) {
                PNode currentNode = queue.poll();

                // if this is not the first node in the level, link the previousNode isRight to current node
                if (previousInLevel != null){
                    previousInLevel.isRight = currentNode;
                }
                previousInLevel = currentNode;

                // standard BFS
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);

            }
            
        }
    }
}
