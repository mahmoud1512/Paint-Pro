package com.example.paintBackend.undoRedo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Stack;

@Service
public class undoRedoService {

    private Stack<ICommand>undoStack=new Stack<>();
    private Stack<ICommand>redoStack=new Stack<>();

    public Stack<ICommand> getUndoStack() {
        return undoStack;
    }

    public void setUndoStack(Stack<ICommand> undoStack) {
        this.undoStack = undoStack;
    }

    public Stack<ICommand> getRedoStack() {
        return redoStack;
    }

    public void setRedoStack(Stack<ICommand> redoStack) {
        this.redoStack = redoStack;
    }

    public void AddToUndoStack(ICommand command) {
        undoStack.push(command);
    }
}
