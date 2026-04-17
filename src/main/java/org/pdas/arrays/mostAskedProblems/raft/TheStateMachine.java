package org.pdas.arrays.mostAskedProblems.raft;

import java.util.Map;

/**
 * Represents the replicated state machine
 * */
public interface TheStateMachine {
    /**
     * Should be able to apply a command to the state machine
     * @param command The command string to execute
     * @return The result of execution
     * */
    String apply(String command);

    /**
     * Return the current state
     * */
    Map<String, String> getState();

}
