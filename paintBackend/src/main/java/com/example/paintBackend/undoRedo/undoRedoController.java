package com.example.paintBackend.undoRedo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class undoRedoController {
    undoRedoService undoRedo;
    @Autowired
    public undoRedoController(undoRedoService service) {
    }
}
