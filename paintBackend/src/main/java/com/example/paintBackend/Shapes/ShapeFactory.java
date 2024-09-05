package com.example.paintBackend.Shapes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ShapeFactory {
    public AbstractShape make(String type, String obj) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        AbstractShape shape = null;
          switch (type){
              case "Rectangle":
                  shape= objectMapper.readValue(obj, Rectangle.class);
                  break;
              case "Circle":
                  shape= objectMapper.readValue(obj, Circle.class);
                  break;
              case "Square":
                  shape= objectMapper.readValue(obj, Square.class);
                  break;
              case "Star":
                  shape= objectMapper.readValue(obj, Star.class);
                  break;
              case "Triangle":
                  shape= objectMapper.readValue(obj, Triangle.class);
                  break;
              case "Ellipse":
                  shape= objectMapper.readValue(obj, Ellipse.class);
                  break;
              case "Line":
                  shape= objectMapper.readValue(obj, LineSegment.class);
                  break;
              default:
                  System.out.println("problem");
                  break;
          }
        System.out.println(shape.getId());
          return shape;
    }
}
