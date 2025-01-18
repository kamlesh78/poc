package com.learning.command;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Getter
@Setter
public class Invoker {

    Stack<Command> undoOperations = new Stack<>();

    public void executeCommand(Command command){
        command.execute();
        undoOperations.add(command);
    }

    public void undo(){
        if(!CollectionUtils.isEmpty(undoOperations)){
            Command pop = undoOperations.pop();
            pop.undo();
        }
    }
}
