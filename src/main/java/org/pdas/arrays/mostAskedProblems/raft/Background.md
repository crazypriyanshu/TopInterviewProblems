## Consensus and Quorum


If Q1 and Q2 are in quorum , this implies that intersection of Q1 and Q2 is not empty
Cluster can make progress as long as consensus among quorum is maintained. - HA/fault tolerance

To get this kind of replicated machine, we have to make sure that when they enter they have the 
> same initial state
> same input sequence - replicated WAL file
> results in same output and internal state transition


Raft is a consensus algorithm designed for manageability. 
It decomposes the consensus problem into three relatively independent sub-problems:
- **Leader Election**: 
        How a leader is elected when the cluster starts or when the current leader fails?
- **Log Replication**: 
      How the leader accepts log entries and ensures they are replicated across the cluster.
  - **Safety**: 
  Ensuring that the state machine remains consistent across all nodes.


So, if let's say in cluster of machines where NodeA is leader in current term and nodeB and nodeC are followers
  - 