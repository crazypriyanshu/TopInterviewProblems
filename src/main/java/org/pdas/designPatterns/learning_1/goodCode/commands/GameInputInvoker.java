package org.pdas.designPatterns.learning_1.goodCode.commands;

import java.util.Stack;

public class GameInputInvoker {
    private Stack<Command> history = new Stack<>();
    public void executeCommand(Command command){
        command.execute();
        history.push(command);
    }

    public void unDoLastAction(){
        if (!history.isEmpty()){
            Command lastCommand = history.pop();
            lastCommand.unDo();
        }
    }
}
