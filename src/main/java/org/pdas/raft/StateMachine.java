package org.pdas.raft;

import java.util.Map;

/**
 * Interface representing the replicated state machine.
 */
public interface StateMachine {
    /**
     * Applies a command to the state machine.
     * @param command The command string to execute.
     * @return The result of the execution.
     */
    String apply(String command);

    /**
     * Returns the current state for debugging/inspection.
     */
    Map<String, String> getState();
}
