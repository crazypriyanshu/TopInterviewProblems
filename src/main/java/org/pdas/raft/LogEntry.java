package org.pdas.raft;

import java.io.Serializable;

/**
 * Represents an entry in the Raft log.
 */
public record LogEntry(long term, String command) implements Serializable {
}
