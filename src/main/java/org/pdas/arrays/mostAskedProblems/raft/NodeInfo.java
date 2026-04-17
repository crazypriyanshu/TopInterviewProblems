package org.pdas.arrays.mostAskedProblems.raft;

import java.io.Serializable;

public record NodeInfo(
        String id,
        String host,
        int port
) implements Serializable {
}
