package com.example.paintBackend.undoRedo;

import com.example.paintBackend.Shapes.AbstractShape;


import java.util.Map;

public class CopyCommand implements ICommand{
    private final String id;
    private final Map<String, AbstractShape>map;
    private CreateCommand command;

    public CopyCommand(String id,Map<String,AbstractShape>map) {
        this.id = id;
        this.map=map;
    }

    @Override
    public void execute() {
        AbstractShape shape=map.get(id);
        AbstractShape copiedShape=shape.Copy();
        command=new CreateCommand(map,id,copiedShape);
    }

    @Override
    public void unExecute() {
         command.unExecute();
    }
}
