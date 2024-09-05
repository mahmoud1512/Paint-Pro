package com.example.paintBackend.undoRedo;

import com.example.paintBackend.Shapes.AbstractShape;

import java.util.HashMap;
import java.util.Map;

public class ClearCommand implements ICommand{
    private final Map<String,AbstractShape>Backup;
    private Map<String,AbstractShape>Original;

    public ClearCommand(Map<String, AbstractShape> map) {
        Original=map;
        Backup=new HashMap<>(map);
    }

    @Override
    public void execute() {
         Original.clear();
    }

    @Override
    public void unExecute() {
         Original=new HashMap<>(Backup);
    }
}
