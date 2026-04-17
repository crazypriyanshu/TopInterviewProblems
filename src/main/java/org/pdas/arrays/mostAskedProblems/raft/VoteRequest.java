package org.pdas.arrays.mostAskedProblems.raft;

public record VoteRequest(
        long term,
        String candidateId,
        long lastLogIndex,
        long lastLogTerm
) {
}
