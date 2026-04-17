package org.pdas.arrays.mostAskedProblems.raft;

import java.util.List;

public record AppendRequest (
    long term,
    String leaderId,
    long previousLogIndex,
    long getPreviousLogTerm,
    List<LogEntry> entries,
    long leaderCommit
) {};
