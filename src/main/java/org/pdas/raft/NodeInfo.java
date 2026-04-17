package org.pdas.raft;

import java.io.Serializable;

/**
 * Information about a node in the Raft cluster.
 */
public record NodeInfo(String id, String host, int port) implements Serializable {
}
