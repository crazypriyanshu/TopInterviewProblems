package org.pdas.arrays.mostAskedProblems.raft;

public record AppendResponse(
        long term,
        boolean success
) {
}
