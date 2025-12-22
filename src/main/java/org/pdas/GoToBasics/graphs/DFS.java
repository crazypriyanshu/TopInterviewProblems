package org.pdas.GoToBasics.graphs;

public class DFS implements TreeConnectionStrategy{
    @Override
    public void connect(PNode root) {
        if (root == null || root.left == null) { return; }
        root.left.isRight = root.right;
        if (root.isRight != null){
            root.right.isRight = root.isRight.left;
        }
        connect(root.left);
        connect(root.right);
    }
}
