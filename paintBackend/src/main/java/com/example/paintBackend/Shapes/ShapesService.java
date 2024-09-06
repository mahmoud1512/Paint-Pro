package com.example.paintBackend.Shapes;

import com.example.paintBackend.undoRedo.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShapesService {

    private Map<String,AbstractShape>IdShapeMapper;
    private ShapeFactory factory;
    @Autowired
    private undoRedoService undoRedoService;


    public void initialize() {
        this.IdShapeMapper=new HashMap<>();
        this.factory=new ShapeFactory();
    }
    public void createShape(String type,String id,String obj) throws JsonProcessingException {
        CreateCommand createCommand=new CreateCommand(IdShapeMapper,id,factory.make(type,obj));
        this.undoRedoService.AddToUndoStack(createCommand);
        createCommand.execute();
    }
    public void copyShape(String id)
    {
        CopyCommand copyCommand=new CopyCommand(id,IdShapeMapper);
        this.undoRedoService.AddToUndoStack(copyCommand);
        copyCommand.execute();
    }
    public void deleteShape(String id)
    {
        DeleteCommand deleteCommand=new DeleteCommand(id,IdShapeMapper);
        this.undoRedoService.AddToUndoStack(deleteCommand);
        deleteCommand.execute();
    }
    public void clear()
    {
        ClearCommand clearCommand=new ClearCommand(IdShapeMapper);
        this.undoRedoService.AddToUndoStack(clearCommand);
        clearCommand.execute();

    }
    public void modifyShape(String id ,String type,String data) throws JsonProcessingException {
        AbstractShape newStateShape=factory.make(type,data);
        ModifyCommand modifyCommand=new ModifyCommand(id,newStateShape,IdShapeMapper);
        this.undoRedoService.AddToUndoStack(modifyCommand);
        modifyCommand.execute();

    }

    public List<AbstractShape> getShapes() {
        return new ArrayList<>(this.IdShapeMapper.values());
    }
}
