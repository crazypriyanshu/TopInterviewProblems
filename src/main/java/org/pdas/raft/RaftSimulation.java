package org.pdas.raft;

import java.util.ArrayList;
import java.util.List;

/**
 * A demonstration of the Raft cluster in action.
 */
public class RaftSimulation {
    public static void main(String[] args) throws InterruptedException {
        int nodeCount = 3;
        List<NodeInfo> nodesInfo = new ArrayList<>();
        for (int i = 1; i <= nodeCount; i++) {
            nodesInfo.add(new NodeInfo("node-" + i, "localhost", 8000 + i));
        }

        List<RaftNode> nodes = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            nodes.add(new RaftNode(nodesInfo.get(i).id(), nodesInfo, new KVStateMachine()));
        }

        // Connect all nodes to each other (simulated network)
        for (RaftNode node : nodes) {
            for (RaftNode peer : nodes) {
                if (!node.getId().equals(peer.getId())) {
                    node.addPeerNode(peer.getId(), peer);
                }
            }
        }

        System.out.println("Raft Cluster started with " + nodeCount + " nodes.");
        
        // Let the election run for a bit
        Thread.sleep(2000);

        // Check if we have a leader
        for (RaftNode node : nodes) {
            System.out.println("Node " + node.getId() + " is in state: " + node.getState());
        }

        System.exit(0);
    }
}
