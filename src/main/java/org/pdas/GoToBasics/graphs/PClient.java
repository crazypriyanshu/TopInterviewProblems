package org.pdas.GoToBasics.graphs;

public class PClient {
    public static void main(String[] args) {
        PNode pNode = new PNode(1);
        pNode.left = new PNode(2);
        pNode.right = new PNode(3);
        pNode.left.left = new PNode(4);
        pNode.left.right = new PNode(5);

        pNode.right.left = new PNode(6);
        pNode.right.right = new PNode(7);
        System.out.println(pNode);

        TreeConnectionStrategy connectionStrategy = new LevelOrderLinker();
        connectionStrategy.connect(pNode);

        System.out.println("Level 2 connection ");
        pNode.left.printLevel();
        System.out.println("Level 3 connection");
        pNode.left.left.printLevel();
    }
}
