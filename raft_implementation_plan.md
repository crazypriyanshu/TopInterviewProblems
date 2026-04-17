# Raft Consensus Algorithm Implementation Plan

This document outlines the phased approach to implementing a Raft-based distributed state machine (Key-Value Store).

## 1. Introduction to Raft
Raft is a consensus algorithm designed for manageability. It decomposes the consensus problem into three relatively independent subproblems:
- **Leader Election**: How a leader is chosen when the cluster starts or when the current leader fails.
- **Log Replication**: How the leader accepts log entries and ensures they are replicated across the cluster.
- **Safety**: Ensuring that the state machine remains consistent across all nodes.

## 2. Project Architecture
We will build a simple Key-Value store where updates are replicated via Raft.

### Core Components
- `Node`: Represents a single server in the Raft cluster.
- `RaftState`: Enum for `FOLLOWER`, `CANDIDATE`, and `LEADER`.
- `LogEntry`: Contains the term number and the command (e.g., `SET x 10`).
- `RaftLog`: A list of `LogEntry` objects.
- `StateMachine`: The actual Key-Value store (a simple `Map<String, String>`).
- `RPCService`: Interface for communication between nodes (`RequestVote`, `AppendEntries`).

## 3. Phased Implementation

### Phase 1: Core Data Structures & State Management
- Define `LogEntry`, `RaftState`, and `Node`.
- Initialize cluster configuration.
- Implement basic state transitions.

### Phase 2: Leader Election
- Implement the "Heartbeat" mechanism.
- Implement the `RequestVote` RPC.
- Handle election timeouts and state transitions to `CANDIDATE` and `LEADER`.

### Phase 3: Log Replication
- Implement the `AppendEntries` RPC.
- Handle client requests (only on the Leader).
- Replicate logs to followers.
- Commit entries once a majority has acknowledged them.

### Phase 4: State Machine Integration
- Once an entry is committed, apply it to the `StateMachine`.
- Provide a simple interface for clients to query and update data.

### Phase 5: Persistence & Fault Tolerance (Optional)
- Persist the log and current term to disk to survive crashes.

## 4. Technology Stack
- **Language**: Java 22
- **Testing**: JUnit 5
- **Communication**: Simple Socket-based or In-Memory simulation for initial testing.

---

## Next Steps
1. Create the base `Raft` package.
2. Define the basic models (`LogEntry`, `RaftState`).
