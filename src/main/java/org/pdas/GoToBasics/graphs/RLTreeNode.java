package org.pdas.GoToBasics.graphs;

public class RLTreeNode implements Node{
    int data;
    Node left;
    Node right;

    RLTreeNode(int data){
        this.data = data;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return printTree(this, "", true);
    }

    public String printTree(RLTreeNode rlTreeNode, String prefix, boolean isTail){
        if (rlTreeNode == null) return "";
        StringBuilder builder = new StringBuilder();
        builder.append(prefix)
                .append(isTail ? "|__" : "|--")
                .append(rlTreeNode.data)
                .append("\n");
        String childPrefix = prefix + (isTail ? "   ": "|  ");
        if (rlTreeNode.left != null || rlTreeNode.right != null){
            builder.append(printTree((RLTreeNode) rlTreeNode.left, childPrefix, false));
            builder.append(printTree((RLTreeNode) rlTreeNode.right, childPrefix, true));
        }
        return builder.toString();

    }

}
