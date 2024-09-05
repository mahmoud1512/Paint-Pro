package com.example.paintBackend.undoRedo;

import com.example.paintBackend.Shapes.AbstractShape;

import java.util.Map;

public class ModifyCommand implements ICommand {
    private final String id;
    private final Map<String, AbstractShape> map;
    private final AbstractShape OldStateShape;
    private final AbstractShape newStateShape;


    public ModifyCommand(String id, AbstractShape newStateShape, Map<String, AbstractShape> map) {
        this.id = id;
        this.newStateShape = newStateShape;
        this.map = map;
        OldStateShape = map.get(id);
    }

    @Override
    public void execute() {
        map.put(id, newStateShape);
    }

    @Override
    public void unExecute() {
        map.put(id, OldStateShape);
    }

}
