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
                  System.out.println(shape.toString());
                  break;
              case "Circle":
                  shape= objectMapper.readValue(obj, Circle.class);
                  System.out.println(shape.toString());
                  break;
              case "Square":
                  shape= objectMapper.readValue(obj, Square.class);
                  System.out.println(shape.toString());
                  break;
              case "Star":
                  shape= objectMapper.readValue(obj, Star.class);
                  System.out.println(shape.toString());
                  break;
              case "Triangle":
                  shape= objectMapper.readValue(obj, Triangle.class);
                  System.out.println(shape.toString());
                  break;
              case "Ellipse":
                  shape= objectMapper.readValue(obj, Ellipse.class);
                  System.out.println(shape.toString());
                  break;
              case "Line":
                  shape= objectMapper.readValue(obj, LineSegment.class);
                  System.out.println(shape.toString());
                  break;
              default:
                  System.out.println("problem");
                  break;
          }
        System.out.println(shape.getId());
          return shape;
    }
}
