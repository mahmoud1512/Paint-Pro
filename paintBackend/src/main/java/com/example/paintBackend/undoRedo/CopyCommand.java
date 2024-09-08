package com.example.paintBackend.undoRedo;

import com.example.paintBackend.Shapes.AbstractShape;


import java.util.Map;

public class CopyCommand implements ICommand{
    private final String id;
    private final Map<String, AbstractShape>map;
    private CreateCommand command;
    private String newID;

    public CopyCommand(String id,String newID,Map<String,AbstractShape>map) {
        this.id = id;
        this.map=map;
        this.newID=newID;
    }

    @Override
    public void execute() {
        AbstractShape shape=map.get(id);
        AbstractShape copiedShape=shape.Copy(newID);
        command=new CreateCommand(map,newID,copiedShape);
        command.execute();
    }

    @Override
    public void unExecute() {
         command.unExecute();
    }
}
