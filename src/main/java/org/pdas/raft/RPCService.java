package org.pdas.raft;

import java.util.List;

/**
 * Interface for Raft Remote Procedure Calls.
 */
public interface RPCService {
    /**
     * Invoked by candidates to gather votes.
     */
    VoteResponse requestVote(VoteRequest request);

    /**
     * Invoked by leader to replicate log entries and as heartbeats.
     */
    AppendResponse appendEntries(AppendRequest request);
}

/**
 * Request to vote for a candidate.
 */
record VoteRequest(long term, String candidateId, long lastLogIndex, long lastLogTerm) {}

/**
 * Response to a vote request.
 */
record VoteResponse(long term, boolean voteGranted) {}

/**
 * Request to append entries to the log.
 */
record AppendRequest(
    long term,
    String leaderId,
    long prevLogIndex,
    long prevLogTerm,
    List<LogEntry> entries,
    long leaderCommit
) {}

/**
 * Response to an append entries request.
 */
record AppendResponse(long term, boolean success) {}
