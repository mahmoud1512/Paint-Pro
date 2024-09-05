package com.example.paintBackend.undoRedo;

import com.example.paintBackend.Shapes.AbstractShape;

import java.util.Map;

public class CreateCommand implements ICommand {

    private Map<String, AbstractShape>map;
    private String id;
    private AbstractShape shape;

    public CreateCommand(Map<String, AbstractShape> map, String id, AbstractShape shape) {
        this.map = map;
        this.id = id;
        this.shape = shape;
    }

    @Override
    public void execute() {
          map.put(id,shape);
    }

    @Override
    public void unExecute() {
          map.remove(id);
    }

}
