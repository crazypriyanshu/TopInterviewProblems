package org.pdas.arrays.mostAskedProblems.raft;

public interface RaftService {
    VoteResponse requestVote(VoteRequest voteRequest);
    AppendResponse appendEntries(AppendRequest appendRequest);

}
