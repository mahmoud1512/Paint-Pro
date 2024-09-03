package com.example.paintBackend.Shapes;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShapesService {

    private Map<String,IShape>IdShapeMapper;
    private ShapeFactory factory;

    public void initialize() {
        this.IdShapeMapper=new HashMap<>();
        this.factory=new ShapeFactory();
    }

}
