package org.pdas.designPatterns.Behavioral.Momento.mementoEg;

import java.util.*;
// Caretaker class - this knows nothing about the Document fields
public class DocumentHistoryManager {
    private final Stack<Document.Memento> documentHistory = new Stack<>();


    public Document.Memento write(Document.Memento memento){
        documentHistory.push(memento);
        System.out.println("Caretaker is pushing in history log : "+memento);
        return memento;

    }

    public Document.Memento unDo(){
        Document.Memento lastLog = documentHistory.isEmpty() ? null :documentHistory.pop();
        System.out.println("Caretaker is undoing last from History for log: "+lastLog);
        System.out.println("Current state of document : "+ documentHistory.peek());
        return lastLog;

    }

}
