package com.example.paintBackend.undoRedo;

import com.example.paintBackend.Shapes.AbstractShape;
import com.example.paintBackend.Shapes.ShapesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
public class undoRedoService {

    private Stack<ICommand>undoStack=new Stack<>();
    private Stack<ICommand>redoStack=new Stack<>();
    @Autowired
    private ShapesService shapesService;

    public Stack<ICommand> getUndoStack() {
        return undoStack;
    }

    public Stack<ICommand> getRedoStack() {
        return redoStack;
    }


    public void AddToUndoStack(ICommand command) {

        undoStack.push(command);
    }
    public void AddToRedoStack(ICommand command)
    {
        redoStack.push(command);
    }
    public List<AbstractShape>PerformUndo()
    {
        ICommand command=undoStack.pop();
        command.unExecute();
        AddToRedoStack(command);
        return this.shapesService.getShapes();
    }
    public List<AbstractShape>PerformRedo()
    {
        ICommand command=redoStack.pop();
        command.execute();
        AddToUndoStack(command);
        return this.shapesService.getShapes();
    }

}
