package org.pdas.arrays.mostAskedProblems.raft;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        int nodeCount = 3;
        List<NodeInfo> nodeInfo = new ArrayList<>();

        for (int i = 1; i <= nodeCount; i++) {
            nodeInfo.add(new NodeInfo("node-"+i, "localhost", 8080+i));
        }

        List<RaftNode> nodes = new ArrayList<>();
        for (int i = 0; i < nodeCount; i++) {
            nodes.add(new RaftNode(nodeInfo.get(i).id(), nodeInfo, new KVStateMachine()));
        }

        // connect all the nodes to each other
        for (RaftNode node: nodes){
            for (RaftNode peer: nodes){
                if (!node.getId().equals(peer.getId())){
                    node.addPeerNodes(peer.getId(), peer);
                }
            }
        }

        System.out.println("---- Raft node started with "+nodeCount+ " servers");
        Thread.sleep(3000);
        for (RaftNode node: nodes){
            System.out.println("Node: "+node.getId()+ " is in state "+node.getState());
        }

        System.out.println("Raft cluster started with "+nodeCount+ " nodes");
        Thread.sleep(3000);
        RaftNode leader = null;
        for (RaftNode node: nodes){
            System.out.println(" Node "+node.getId()+ " is in state "+node.getState());
            if (node.getState() == RaftState.LEADER){
                leader = node;
            }
        }

        if (leader != null){
            System.out.println("Proposing commands to leader: "+leader.getId()+ " ====");
            leader.propose("SET color blue");
            leader.propose("SET mode red");
            leader.propose("SET amazing target");
            leader.propose("SET version 2.0");
            Thread.sleep(3000);
            System.out.println(" \n -- Final state consistency check -- \n");
            for (RaftNode node: nodes){
                System.out.println("Node: "+node.getId()+ " data: "+node.getStateMachineData());
            }
        } else {
            System.out.println("No leader was elected");
        }

        System.exit(0);
    }
}
