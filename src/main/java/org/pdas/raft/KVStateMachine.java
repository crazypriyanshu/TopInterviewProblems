package org.pdas.raft;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A simple Key-Value Store implementation of a State Machine.
 * Supports commands like "SET key value" or "GET key".
 */
public class KVStateMachine implements StateMachine {
    private final Map<String, String> db = new ConcurrentHashMap<>();

    @Override
    public String apply(String command) {
        String[] parts = command.split(" ");
        if (parts.length < 2) return "ERROR: Invalid command";

        String action = parts[0].toUpperCase();
        String key = parts[1];

        switch (action) {
            case "SET":
                if (parts.length < 3) return "ERROR: Missing value for SET";
                db.put(key, parts[2]);
                return "OK";
            case "GET":
                return db.getOrDefault(key, "NIL");
            case "DELETE":
                db.remove(key);
                return "OK";
            default:
                return "ERROR: Unknown command " + action;
        }
    }

    @Override
    public Map<String, String> getState() {
        return Collections.unmodifiableMap(db);
    }
}
