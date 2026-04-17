package org.pdas.raft;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The core Raft Node implementation.
 */
public class RaftNode implements RPCService {
    private final String id;
    private final List<NodeInfo> peers;
    private final java.util.Map<String, RaftNode> peerNodes = new java.util.HashMap<>(); // Simulated network

    // Persistent state on all servers
    private long currentTerm = 0;
    private String votedFor = null;
    private final List<LogEntry> log = new ArrayList<>();

    // Volatile state on all servers
    private long commitIndex = 0;
    private long lastApplied = 0;

    // Volatile state on leaders (re-initialized after election)
    private java.util.Map<String, Long> nextIndex = new java.util.HashMap<>();
    private java.util.Map<String, Long> matchIndex = new java.util.HashMap<>();

    private final StateMachine stateMachine;
    private RaftState state = RaftState.FOLLOWER;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    private ScheduledFuture<?> electionTimer;
    private ScheduledFuture<?> heartbeatTimer;
    private final Random random = new Random();

    public RaftNode(String id, List<NodeInfo> peers, StateMachine stateMachine) {
        this.id = id;
        this.peers = peers;
        this.stateMachine = stateMachine;
        // The log is 1-indexed in Raft literature, adding a dummy entry to simplify.
        log.add(new LogEntry(0, "INIT"));
        resetElectionTimer();
    }

    public void addPeerNode(String id, RaftNode node) {
        peerNodes.put(id, node);
    }

    public synchronized void resetElectionTimer() {
        if (electionTimer != null) {
            electionTimer.cancel(false);
        }
        long timeout = 150 + random.nextInt(150); // 150-300ms
        electionTimer = scheduler.schedule(this::startElection, timeout, TimeUnit.MILLISECONDS);
    }

    private synchronized void startElection() {
        if (state == RaftState.LEADER)
            return;

        System.out.println("Node " + id + " starting election for term " + (currentTerm + 1));
        state = RaftState.CANDIDATE;
        currentTerm++;
        votedFor = id;

        resetElectionTimer();

        long lastLogIndex = log.size() - 1;
        long lastLogTerm = log.get((int) lastLogIndex).term();
        VoteRequest request = new VoteRequest(currentTerm, id, lastLogIndex, lastLogTerm);

        AtomicInteger votesReceived = new AtomicInteger(1); // Vote for self
        int majority = (peerNodes.size() + 1) / 2 + 1;

        for (String peerId : peerNodes.keySet()) {
            final int termAtStart = (int) currentTerm;
            scheduler.execute(() -> {
                VoteResponse response = peerNodes.get(peerId).requestVote(request);
                if (response != null) {
                    handleVoteResponse(response, termAtStart, majority, votesReceived);
                }
            });
        }
    }

    private synchronized void handleVoteResponse(VoteResponse response, long termAtStart, int majority,
            AtomicInteger votesReceived) {
        if (state != RaftState.CANDIDATE || currentTerm != termAtStart)
            return;

        if (response.term() > currentTerm) {
            currentTerm = response.term();
            state = RaftState.FOLLOWER;
            votedFor = null;
            resetElectionTimer();
            return;
        }

        if (response.voteGranted()) {
            if (votesReceived.incrementAndGet() >= majority) {
                becomeLeader();
            }
        }
    }

    private synchronized void becomeLeader() {
        if (state != RaftState.CANDIDATE)
            return;
        System.out.println("Node " + id + " became LEADER for term " + currentTerm);
        state = RaftState.LEADER;
        if (electionTimer != null)
            electionTimer.cancel(false);

        for (NodeInfo peer : peers) {
            nextIndex.put(peer.id(), (long) log.size());

            matchIndex.put(peer.id(), 0L);
        }

        startHeartbeats();
    }

    private void startHeartbeats() {
        heartbeatTimer = scheduler.scheduleAtFixedRate(this::sendHeartbeats, 0, 50, TimeUnit.MILLISECONDS);
    }

    private synchronized void sendHeartbeats() {
        if (state != RaftState.LEADER) {
            if (heartbeatTimer != null)
                heartbeatTimer.cancel(false);
            return;
        }

        for (String peerId : peerNodes.keySet()) {
            long ni = nextIndex.getOrDefault(peerId, (long) log.size());
            long prevLogIndex = ni - 1;
            long prevLogTerm = log.get((int) prevLogIndex).term();
            
            List<LogEntry> entries = new ArrayList<>();
            if (log.size() > ni) {
                entries = new ArrayList<>(log.subList((int) ni, log.size()));
            }

            final long lastLogIndexSent = prevLogIndex + entries.size();
            AppendRequest request = new AppendRequest(
                    currentTerm,
                    id,
                    prevLogIndex,
                    prevLogTerm,
                    entries,
                    commitIndex);

            scheduler.execute(() -> {
                AppendResponse response = peerNodes.get(peerId).appendEntries(request);
                if (response != null) {
                    handleAppendResponse(peerId, response, request.term(), lastLogIndexSent);
                }
            });
        }
    }

    private synchronized void handleAppendResponse(String peerId, AppendResponse response, long termSent, long lastLogIndexSent) {
        if (state != RaftState.LEADER || currentTerm != termSent)
            return;

        if (response.term() > currentTerm) {
            currentTerm = response.term();
            state = RaftState.FOLLOWER;
            votedFor = null;
            resetElectionTimer();
            return;
        }

        if (response.success()) {
            matchIndex.put(peerId, Math.max(matchIndex.getOrDefault(peerId, 0L), lastLogIndexSent));
            nextIndex.put(peerId, matchIndex.get(peerId) + 1);
            updateCommitIndex();
        } else {
            // Log inconsistency, decrement nextIndex and retry
            long currentNext = nextIndex.getOrDefault(peerId, 1L);
            nextIndex.put(peerId, Math.max(1L, currentNext - 1));
        }
    }

    private synchronized void updateCommitIndex() {
        // Leader looks for N such that N > commitIndex, a majority of matchIndex[i] >= N,
        // and log[N].term == currentTerm.
        for (long n = log.size() - 1; n > commitIndex; n--) {
            if (log.get((int) n).term() == currentTerm) {
                int count = 1; // Count self
                for (long match : matchIndex.values()) {
                    if (match >= n) count++;
                }
                if (count >= (peerNodes.size() + 1) / 2 + 1) {
                    commitIndex = n;
                    applyLogEntries();
                    break;
                }
            }
        }
    }

    @Override
    public synchronized VoteResponse requestVote(VoteRequest request) {
        if (request.term() < currentTerm) {
            return new VoteResponse(currentTerm, false);
        }

        if (request.term() > currentTerm) {
            currentTerm = request.term();
            state = RaftState.FOLLOWER;
            votedFor = null;
        }

        if ((votedFor == null || votedFor.equals(request.candidateId())) && isLogUpToDate(request)) {
            votedFor = request.candidateId();
            resetElectionTimer();
            return new VoteResponse(currentTerm, true);
        }

        return new VoteResponse(currentTerm, false);
    }

    private boolean isLogUpToDate(VoteRequest request) {
        long lastLogTerm = log.get(log.size() - 1).term();
        long lastLogIndex = log.size() - 1;

        if (request.lastLogTerm() != lastLogTerm) {
            return request.lastLogTerm() > lastLogTerm;
        }
        return request.lastLogIndex() >= lastLogIndex;
    }

    @Override
    public synchronized AppendResponse appendEntries(AppendRequest request) {
        if (request.term() < currentTerm) {
            return new AppendResponse(currentTerm, false);
        }

        if (request.term() >= currentTerm) {
            currentTerm = request.term();
            state = RaftState.FOLLOWER;
            votedFor = null;
        }

        resetElectionTimer();

        // 1. Reply false if log doesn't contain an entry at prevLogIndex whose term
        // matches prevLogTerm
        if (request.prevLogIndex() >= log.size()
                || log.get((int) request.prevLogIndex()).term() != request.prevLogTerm()) {
            return new AppendResponse(currentTerm, false);
        }

        // 2. If an existing entry conflicts with a new one (same index but different
        // terms),
        // delete the existing entry and all that follow it
        // 3. Append any new entries not already in the log
        int index = (int) request.prevLogIndex() + 1;
        for (LogEntry entry : request.entries()) {
            if (index < log.size()) {
                if (log.get(index).term() != entry.term()) {
                    while (log.size() > index) {
                        log.remove(log.size() - 1);
                    }
                    log.add(entry);
                }
            } else {
                log.add(entry);
            }
            index++;
        }

        // 4. If leaderCommit > commitIndex, set commitIndex = min(leaderCommit, index
        // of last new entry)
        if (request.leaderCommit() > commitIndex) {
            commitIndex = Math.min(request.leaderCommit(), log.size() - 1);
            applyLogEntries();
        }

        return new AppendResponse(currentTerm, true);
    }

    private void applyLogEntries() {
        while (lastApplied < commitIndex) {
            lastApplied++;
            LogEntry entry = log.get((int) lastApplied);
            if ("INIT".equals(entry.command())) continue;
            
            System.out.println("Node " + id + " applying command at index " + lastApplied + ": " + entry.command());
            String applyResult = stateMachine.apply(entry.command());
            System.out.println("Node " + id + " result: " + applyResult);
        }
    }

    public String getId() {
        return id;
    }

    public RaftState getState() {
        return state;
    }
}
