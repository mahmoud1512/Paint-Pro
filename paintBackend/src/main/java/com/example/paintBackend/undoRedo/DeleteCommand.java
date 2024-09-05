package com.example.paintBackend.undoRedo;

import com.example.paintBackend.Shapes.AbstractShape;

import java.util.Map;

public class DeleteCommand implements ICommand{
    private String id;
    private Map<String,AbstractShape>map;
    private AbstractShape shape;
    public DeleteCommand(String id, Map<String, AbstractShape> map) {
        this.id=id;
        this.map=map;
    }

    @Override
    public void execute() {
         shape= map.get(id);
         map.remove(id);
    }

    @Override
    public void unExecute() {
          map.put(id,shape);
    }
}
