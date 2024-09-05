package com.example.paintBackend.undoRedo;

import com.example.paintBackend.Shapes.AbstractShape;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class CopyCommand implements ICommand{
    private String id;
    private Map<String, AbstractShape>map;
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
