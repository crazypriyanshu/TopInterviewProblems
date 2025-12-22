package org.pdas.GoToBasics.graphs;

public class PNode implements Node{
    int data;
    PNode left;
    PNode right;
    PNode isRight;

    public PNode(int data) {
        this.data = data;
        left = null;
        right = null;
        isRight = null;
    }

    @Override
    public String toString() {
        return """
               [ Data: %d | Neighbor: %s ]
               """.formatted(data, (isRight != null ? isRight.data : "NULL"));
    }

    void printLevel() {
        PNode temp = this;
        while (temp != null){
            System.out.println(temp.data + " -> ");
            temp = temp.isRight;
        }
        System.out.println("NULL");
    }
}
