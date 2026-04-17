package org.pdas.arrays.mostAskedProblems.raft;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KVStateMachine implements TheStateMachine{
    private final Map<String, String> db = new ConcurrentHashMap<>();
    @Override
    public String apply(String command) {
        String[] parts = command.split(" ");
        if (parts.length < 2) return "Invalid command";

        String action = parts[0].toUpperCase();
        String key = parts[1];

        switch (action){
            case "SET":
                if (parts.length < 3) return "ERROR: Missing value for SET command";
                db.put(key, parts[2]);
                return "OK";
            case "GET":
                return db.getOrDefault(key, "NIL");
            case "DELETE":
                if (!db.containsKey(key)) return "ERROR: Key not found to do delete";
                db.remove(key);
                return "OK";
            default:
                return "ERROR: Unknown command, use SET, GET OR DELETE";
        }
    }

    @Override
    public Map<String, String> getState() {
        return Collections.unmodifiableMap(db);
    }
}
