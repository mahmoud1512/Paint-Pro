package com.example.paintBackend.Shapes;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShapesService {

    private Map<String,AbstractShape>IdShapeMapper;
    private ShapeFactory factory;


    public void initialize() {
        this.IdShapeMapper=new HashMap<>();
        this.factory=new ShapeFactory();
    }
    public void createShape(String type,String id,String obj) throws JsonProcessingException {
        IdShapeMapper.put(id,factory.make(type,obj));
    }

}
