package org.pdas.designPatterns.Behavioral.Memento.antiPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// The Caretaker class
public class DocumentHistoryManager {
    private Stack<Map<String, Object>> undoStack = new Stack<>();

    public void save(Document document){
        Map<String, Object> state = new HashMap<>();
        state.put("content", document.content);
        state.put("x_coordinate", document.getX_coordinate());
        state.put("y_coordinate", document.getY_coordinate());
        undoStack.push(state);
    }

    public void unDo(Document document){
        if (!undoStack.isEmpty()){
            Map<String, Object> state = undoStack.pop();
            document.content = (String) state.get("content");
            document.x_coordinate = (int) state.get("x_coordinate");
            document.y_coordinate = (int) state.get("y_coordinate");
        }
    }

}
