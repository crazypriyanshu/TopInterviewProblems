package org.pdas.arrays.mostAskedProblems.raft;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Raft implementation
 * */
public class RaftNode implements RaftService{

    private final String id;
    private final List<NodeInfo> peers;
    private final Map<String, RaftNode> peerNodes = new HashMap<>();

    // Persistent state on all servers
    private long currentTerm=0;
    private String votedFor = null;
    private final List<LogEntry> logs = new ArrayList<>();

    // volatile states on all servers
    private long commitIndex = 0;
    private long lastApplied = 0;

    // volatile state only for LEADERS (re-initialize after every election)
    private Map<String, Long> nextIndex = new HashMap<>(); // entries for leader to send the next log entry
    private Map<String, Long> matchIndex = new HashMap<>(); // tracks the highest log entry known to be replicated on that specific follower

    private RaftState state = RaftState.FOLLOWER;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    private ScheduledFuture<?> electionTimer;
    private ScheduledFuture<?> heartbeatTimer;
    private final Random random = new Random();
    private final TheStateMachine stateMachine;


    public RaftNode(String id, List<NodeInfo> peers, TheStateMachine stateMachine){
        this.id = id;
        this.peers = peers;
        this.stateMachine = stateMachine;
        logs.add(new LogEntry(0, "INIT"));
        resetElectionTimer();
    }

    public void addPeerNodes(String id, RaftNode node){
        peerNodes.put(id, node);
    }

    private synchronized void resetElectionTimer(){
        if (electionTimer != null){
            electionTimer.cancel(false);
        }
        long timeout = 150 + random.nextInt(150);
        electionTimer = scheduler.schedule(this::startElection, timeout, TimeUnit.SECONDS);
    }

    private synchronized void startElection(){
        if (state == RaftState.LEADER) return;
        System.out.println("Node: "+id+" is starting election for term: "+(currentTerm+1));

        state = RaftState.CANDIDATE;
        currentTerm++;
        votedFor = id;
        resetElectionTimer();

        long lastLogIndex = logs.size()-1;
        long lastLogTerm = logs.get((int) lastLogIndex).term();
        VoteRequest voteRequest = new VoteRequest(currentTerm, id, lastLogIndex, lastLogTerm);

        AtomicInteger votesReceived = new AtomicInteger(1); // vote for self
        int majority = (peerNodes.size()+1)/2 +1;

        for (String peerId: peerNodes.keySet()){
            final int termAtStart = (int) currentTerm;
            scheduler.execute(() -> {
                VoteResponse response = peerNodes.get(peerId).requestVote(voteRequest);
                if (response != null){
                    handleVoteResponse(response, termAtStart, majority, votesReceived );
                }
            });
        }
    }

    private void handleVoteResponse(VoteResponse response, int termAtStart, int majority, AtomicInteger votesReceived) {
        if (state != RaftState.CANDIDATE || currentTerm != termAtStart) return;
        if (response.term() > currentTerm){
            currentTerm = response.term();
            state = RaftState.FOLLOWER;
            votedFor = null;
            resetElectionTimer();
            return;
        }
        if (response.voteGranted()){
            if (votesReceived.incrementAndGet() >= majority){
                becomeLeader();
            }
        }
    }

    /**
     * Allocating a Raft Node from candidate state to Leader state
     * update all the
     * */
    private synchronized void becomeLeader() {
        if (state != RaftState.CANDIDATE) return;
        System.out.println("Node: "+id+" became leader for term: "+currentTerm);
        state = RaftState.LEADER;
        if (electionTimer != null) electionTimer.cancel(false);
        for (NodeInfo peer: peers){
            nextIndex.put(peer.id(), (long) logs.size());
            matchIndex.put(peer.id(), 0L);
        }
        startHeartBeat();

    }

    private void startHeartBeat() {
        heartbeatTimer = scheduler.scheduleAtFixedRate(this::sendHeartBeats, 0, 1, TimeUnit.SECONDS);
    }

    /**
     * Responsible for sending heartbeats
     * Only leader can send the heartbeats to all the peers
     * */
    private synchronized void sendHeartBeats(){
        if (state != RaftState.LEADER){
            if (heartbeatTimer != null) heartbeatTimer.cancel(false);
            return;
        }
        for (String peerId: peerNodes.keySet()){
            long nIdx = nextIndex.getOrDefault(peerId, (long) logs.size());
            long prevIdx = nIdx-1;
            long previousLogTerm = logs.get((int) prevIdx).term();
            List<LogEntry> entries = new ArrayList<>();
            if (logs.size() > nIdx){
                entries = new ArrayList<>(logs.subList((int) nIdx, logs.size()));
            }
            final long lastLogIndexSent = prevIdx+entries.size();

            AppendRequest request = new AppendRequest(currentTerm, id, prevIdx, previousLogTerm, entries, commitIndex);
            scheduler.execute(() -> {
                AppendResponse response = peerNodes.get(peerId).appendEntries(request);
                if (response != null){
                    handleAppendResponse(peerId, response, request.term(), lastLogIndexSent);
                }
            });
        }
    }

    private void handleAppendResponse(String peerId, AppendResponse response, long term, long lastLogIndexSent) {
        if (state != RaftState.LEADER || currentTerm != term) return;
        if (response.term() > currentTerm){
            // if we discover that response's term
            currentTerm = response.term();
            state = RaftState.FOLLOWER;
            votedFor = null;
            resetElectionTimer();
            return;

        }
        if (response.success()){
            matchIndex.put(peerId, Math.max(matchIndex.getOrDefault(peerId, 0L), lastLogIndexSent));
            nextIndex.put(peerId, matchIndex.get(peerId)+1);
            updateCommitIndex();
        } else {
            // Logs are inconsistent , we decrease nextIndex and retry
            long currNext = nextIndex.getOrDefault(peerId, 1L);
            nextIndex.put(peerId, Math.max(1L, currNext-1));
        }

    }

    private synchronized void updateCommitIndex() {

    }

    @Override
    public VoteResponse requestVote(VoteRequest request) {
        if (request.term() < currentTerm){
            return new VoteResponse(currentTerm, false);
        }

        // if request's term is > current term, state of that RaftNode is follower, nd update the current term
        if (request.term() > currentTerm){
            currentTerm = request.term();
            state = RaftState.FOLLOWER;
            votedFor = null;
        }

        // if the voteFor == candidate's id or null, and log is up to date means request's last log index >= current last Log index
        // then we will return Vote response as true
        if ((votedFor == null || votedFor.equals(request.candidateId())) && isLogUpToDate(request)){
            votedFor = request.candidateId();
            resetElectionTimer();
            return new VoteResponse(currentTerm, true);
        }
        return new VoteResponse(currentTerm, false);
    }

    /**
     * Should be able to verify a request
     * verify term and lastLogIndex
     * if request's last log index >= current last Log index then we consider log entries are up to date
     * */
    private boolean isLogUpToDate(VoteRequest request){
        long lastLogTerm = logs.get(logs.size()-1).term();
        long lastLogIndex = logs.size()-1;
        if (request.lastLogTerm() != lastLogTerm){
            return request.lastLogTerm() > lastLogTerm;
        }
        return request.lastLogIndex() >= lastLogIndex;
    }

    @Override
    /**
     * This method defines the logic for log entry, we have to append the entries
     * Keep followers from starting a new election - Heartbeat
     * Ensures that all nodes eventually has same  logs in same order
     * */
    public synchronized AppendResponse appendEntries(AppendRequest request) {
        // if request is old, reject it
        if (request.term() < currentTerm){
            return new AppendResponse(currentTerm, false);
        }

        // if request term > current term, update the curr term and make the state as follower
        // recognize new Leader by becoming a follower
        if (request.term() >= currentTerm){
            currentTerm = request.term();
            state = RaftState.FOLLOWER;
            votedFor = null;
        }
        resetElectionTimer();


        // Reply false if log doesn't contain an entry of prevLogIndex whose term matches previousLogTerm
        // we check request prevLogIndex : Leader is sending entries starting from prevLogIndex and follower checks that has exact same entry, if not
        // means logs are diverged, by returning false, follower forces leader to backtrack(nextIndex--) until they find a common point in history
        if (request.previousLogIndex() >= logs.size() || logs.get((int) request.previousLogIndex()).term() != request.getPreviousLogTerm()){
            return new AppendResponse(currentTerm, false);
        }

        // if flow comes here that means follower and leader logs are consistent, now follower should merge its log with leader entries
        int index = (int) request.previousLogIndex()+1;
        for (LogEntry entry: request.entries()){
            if (index < logs.size()){
                // check if the entry term !=
                if (logs.get(index).term() != entry.term()) {
                    while (logs.get(index).term() != entry.term()) {
                        // conflict resolution : if follower has entry at an index that differs from what leader has sent(diff term), follower deletes its entry and everything else after it
                        logs.remove(logs.size() - 1);
                    }
                    logs.add(entry);
                }
            } else {
                logs.add(entry);
            }
            index++;

        }

        // advancing, leader says i have successfully replicated entries up to leaderCommit on majority of nodes, then follower- applyLogEntries
        if (request.leaderCommit() > commitIndex){
            commitIndex = Math.min(request.leaderCommit(), logs.size()-1);
            applyLogEntries();
        }
        return new AppendResponse(currentTerm, true);
    }

    /**
     * contains logic for marking followers marking the entries committed
     * */
    private void applyLogEntries() {
        while (lastApplied < commitIndex){
            lastApplied++;
            LogEntry entry = logs.get((int) lastApplied);
            System.out.println("Node "+id+" applying command: "+entry.command());
            // When we created the RaftNode, we added a "dummy" entry at index 0 called "INIT".
            // We skip it because it's not a real command from a user (like SET key value); it's just a placeholder to align our indexes.
            if ("INIT".equals(entry.command())) continue;
            System.out.println("Node "+id+" is applying command at index "+lastApplied+ " : "+entry.command());
            String result = stateMachine.apply(entry.command());
            System.out.println("Node: "+id+ " result: "+result);
        }
    }

    public String getId() {
        return id;
    }

    public RaftState getState() {
        return state;
    }
}
