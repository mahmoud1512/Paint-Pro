package com.example.paintBackend.undoRedo;

import com.example.paintBackend.Shapes.AbstractShape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class undoRedoController {
    private undoRedoService undoRedo;
    @Autowired
    public undoRedoController(undoRedoService service) {
        this.undoRedo=service;
    }

    @GetMapping("/undo")
    public List<AbstractShape>undo()
    {
        return this.undoRedo.PerformUndo();
    }
    @GetMapping("/redo")
    public List<AbstractShape>redo()
    {
        return this.undoRedo.PerformRedo();
    }
}
