package org.pdas.arrays.mostAskedProblems.raft;

import java.io.Serializable;

public record LogEntry(long term, String command) implements Serializable {
}
